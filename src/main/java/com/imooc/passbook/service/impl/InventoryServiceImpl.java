package com.imooc.passbook.service.impl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-11
 * Time: 下午7:33
 */

import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.dao.MerchantsDao;
import com.imooc.passbook.entity.Merchants;
import com.imooc.passbook.mapper.PassTemplateRowMapper;
import com.imooc.passbook.service.IInventoryService;
import com.imooc.passbook.service.IUserPassService;
import com.imooc.passbook.utils.RowKeyGenUtil;
import com.imooc.passbook.vo.*;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.LongComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 获取库存信息，只返回用户没有领取的
 */
@Slf4j
@Service
public class InventoryServiceImpl implements IInventoryService {

    private final HbaseTemplate hbaseTemplate;

    private final MerchantsDao merchantsDao;

    private final IUserPassService userPassService;

    @Autowired
    public InventoryServiceImpl(HbaseTemplate hbaseTemplate, MerchantsDao merchantsDao, IUserPassService userPassService) {
        this.hbaseTemplate = hbaseTemplate;
        this.merchantsDao = merchantsDao;
        this.userPassService = userPassService;
    }

    /**
     * 获取库存信息
     * @param userId 用户id
     * @return {@link Response}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Response getInventoryInfo(Long userId) throws Exception {

        Response allUserPass = userPassService.getUserPassInfo(userId);
        List<PassInfo> passInfos = (List<PassInfo>)allUserPass.getData();

        List<PassTemplate> excludeObject = passInfos.stream().map(
                PassInfo::getPassTemplate
            ).collect(Collectors.toList());

        List<String> excludeIds = new ArrayList<>();

        excludeObject.forEach(e -> excludeIds.add(RowKeyGenUtil.genPassTemplateRowKey(e)));

        return new Response(new InventoryResponse(userId,buildPassTemplateInfo(getAvailiablePassTemplate(excludeIds))));
    }

    /**
     * 获取系统中可用的优惠券
     * @param excludeIds 需要排除的优惠券
     * @return {@link PassTemplate}
     */
    private List<PassTemplate> getAvailiablePassTemplate(List<String> excludeIds){
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);

        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.GREATER,
                        new LongComparator(0L)
                )
        );

        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.EQUAL,
                        Bytes.toBytes("-1")
                )
        );

        Scan scan = new Scan();
        scan.setFilter(filterList);

        List<PassTemplate> validTemlates = hbaseTemplate.find(Constants.PassTemplateTable.TABLE_NAME,scan,new PassTemplateRowMapper());

        List<PassTemplate> availablePassTemplates = new ArrayList<>();
        Date cur = new Date();
        for (PassTemplate validTemplate : validTemlates){
            if (excludeIds.contains(RowKeyGenUtil.genPassTemplateRowKey(validTemplate))){
                continue;
            }
            if (cur.getTime() >= validTemplate.getStartTime().getTime()
              && cur.getTime() <= validTemplate.getEndTime().getTime()){
                availablePassTemplates.add(validTemplate);
            }
        }
        return availablePassTemplates;

    }

    /**
     * 构造优惠券的信息
     * @param passTemplates {@link PassTemplate}
     * @return {@link PassTemplateInfo}
     */
    private List<PassTemplateInfo> buildPassTemplateInfo(List<PassTemplate> passTemplates){
        Map<Integer, Merchants> merchantsMap = new HashMap<>();
        List<Integer> mercahntsIds = passTemplates.stream().map(
                PassTemplate::getId
        ).collect(Collectors.toList());
        List<Merchants> merchants = merchantsDao.findByIdIn(mercahntsIds);

        merchants.forEach(m -> merchantsMap.put(m.getId(),m));

        List<PassTemplateInfo> result = new ArrayList<>(passTemplates.size());

        for (PassTemplate passTemplate :passTemplates){
            Merchants mc = merchantsMap.getOrDefault(passTemplate.getId(),null);
            if (null == mc){
                log.error("Merchants Error:{}",passTemplate.getId());
                continue;
            }

            result.add(new PassTemplateInfo(passTemplate,mc));
        }
        return result;
    }
}
