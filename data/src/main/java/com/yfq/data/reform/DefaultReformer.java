/**
 * 
 */
package com.yfq.data.reform;

import com.yfq.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Bean
 * @see DefaultReformer2
 */
@Deprecated
@Slf4j
public class DefaultReformer<PO, VO> extends AbstractConvert<PO, VO> {
	public DefaultReformer() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public VO toVO(PO po) {
		String poCls = po.getClass().getName();
		String voClsName = poCls.substring(0, poCls.indexOf("PO"));
		voClsName = voClsName.replace(".dal.entity.", ".spi.data.");
		try {
			Class<?> cls = Thread.currentThread().getContextClassLoader().loadClass(voClsName);
			VO vo = (VO) cls.newInstance();
			BeanUtil.copyPropertiesFromBean2Bean(po, vo);

			return vo;
		} catch (Exception exp) {
			log.error("对象转换失败.", exp);
			throw new ServiceException("从PO转换VO失败, VO class path = " + voClsName + " :" + exp.getMessage());
		}
	}
}
