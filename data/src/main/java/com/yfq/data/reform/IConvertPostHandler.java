/**
 * 
 */
package com.yfq.data.reform;

/**
 * @author Bean
 *
 */
public interface IConvertPostHandler<PO, VO> {
	public void post(PO po, VO vo);
}
