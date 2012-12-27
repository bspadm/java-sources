package bspapps;

/**
 * Bundesbank-Depotstatistik
 * Transformation XML -(XSL)-> CSV
 * @author jelsen
 */
public class TransformAccountStatistics {

   public static void main(String[] args) {
      com.sun.org.apache.xalan.internal.xslt.Process process =
              new com.sun.org.apache.xalan.internal.xslt.Process();
      process._main(args);
   }
   
}
