/**
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.misc;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class demonstrates how to write <i>Doc Comments</i> in java<br> You can
 * use <b>HTML formating</b> and some special tags starting with "@"<br> Hover
 * mouse over <code>getImage</code> and see the result (Eclipse).<br> Javadoc
 * comments always start with "/**".
 *
 * @author jelsen
 */
public class JavadocExample {

   /**
    * Returns an
    * <code>Image</code> object that can then be painted on the screen.<br> The
    * URL argument must specify an absolute {@link URL}.<br> The name argument
    * is a specifier that is relative to the URL argument.<p>
    *
    * @param url an absolute URL giving the base location of the image
    * @param name the location of the image, relative to the URL argument
    * @return the image at the specified URL
    * @see Image
    * @since R7600
    * @author BSP
    */
   public Image getImage(URL url, String name) {
      try {
         return getImage(new URL(url, name), name);
      } catch (MalformedURLException e) {
         return null;
      }
   }

   /**
    * Demonstrates that a package private variable cannot be used outside
    * it's package.
    */
   public void testPackagePrivateVariable() {
      // System.out.println(PublicPrivateExample.packagePrivateVariable);
   }
}
