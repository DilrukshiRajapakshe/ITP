/** IT17119122
 * Liyanage I.M */
package com.model;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class myWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {itpConfig.class};
	}

   @Override
   protected String[] getServletMappings() {
  
		return new String[] {"/"};
	}

}
