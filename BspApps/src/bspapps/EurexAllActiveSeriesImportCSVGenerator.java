package bspapps;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * Eurex Report TA111 Import<br>
 * CLI Parameter 1: XML Source File<br>
 * CLI Parameter 2: CSV Target File<br>
 * CLI Parameter 3: rewrite XML with line breaks <i>normally true</i>
 * @author rme
 * @version Eurex New Trading Architecture V.1.0
 */
public class EurexAllActiveSeriesImportCSVGenerator {

	/**
	 * CSV header line. All exported Fields.<br>
	 * Any new field will cause structural changes in BSP TRADE.
	 * Program: DTM500 File: DTTB.
	 */
	private static final String CSV_HEADER_LINE = "prodId;prodLngNam;prodTypId;isinCod;undrIsin;currTypCod;"
			+ "mgnClsCod;mgnStyle;exerStylTyp;setlTypCod;finSetlmtTim;"
			+ "usTrdrFlg;blkTrdFlg;flxCntrTrdAllwdFlg;minBlkSiz;dispDcml;exerPrcDcml;ticSiz;ticVal;"
			+ "cntrClasCod;cntrProdId;cntrExpMthDat;cntrExpYrDat;cntrExerPrc;cntrVersNo;cntrStsCod;"
			+ "expDat;valorNum;lepoFlg;trdUnt;trdUntShares;trdUntCsh";

	private static enum Element {
		START, END, CHARACTERS
	}

	/**
	 * ta111Grp, repeated 0 ... variable times
	 */
	class Ta111Grp {
		protected String prodId = null;
		protected String prodLngNam = null;
		protected String prodTypId = null;
		protected String uniqueProdId = null;
		protected List<Ta111ProdRec> ta111ProdRecs = new ArrayList<Ta111ProdRec>();
		protected List<Ta111QuoteSpreadRec> ta111QuoteSpreadRecs = new ArrayList<Ta111QuoteSpreadRec>();
		protected List<Ta111PriceStepRec> ta111PriceStepRecs = new ArrayList<Ta111PriceStepRec>();
		protected List<Ta111EbsDataRec> ta111EbsDataRecs = new ArrayList<Ta111EbsDataRec>();
		protected List<Ta111EbsHdrRec> ta111EbsHdrRecs = new ArrayList<Ta111EbsHdrRec>();
		protected List<Ta111CntrRec> ta111CntrRecs = new ArrayList<Ta111CntrRec>();
		protected List<Ta111SpinOffRec> ta111SpinOffRecs = new ArrayList<Ta111SpinOffRec>();
	}

	/**
	 * ta111ProdRec, repeated 1 ... variable times
	 */
	class Ta111ProdRec {
		protected String prodExchAff = null;
		protected String isinCod = null;
		protected String undrIsin = null;
		protected String stlCurrTypCod = null;
		protected String currTypCod = null;
		protected String mgnClsCod = null;
		protected String mgnStyle = null;
		protected String exerStylTyp = null;
		protected String setlTypCod = null;
		protected String finSetlmtTim = null;
		protected String usTrdrFlg = null;
		protected String blkTrdFlg = null;
		protected String flxCntrTrdAllwdFlg = null;
		protected String minBlkSiz = null;
		protected String dispDcml = null;
		protected String exerPrcDcml = null;
		protected String ticSiz = null;
		protected String ticVal = null;
		protected String matchTypeCode = null;
		protected String stratMatchCode = null;
		protected String oneSideQuoteAlwdFlg = null;
		protected String eqBidAskQtyReqrFlg = null;
		protected String maxPrice = null;
		protected String quoteMinQty = null;
		protected String fastMktQuoteMinQty = null;
		protected String fastMarketQuotePcnt = null;
		protected String undrIdCod = null;
		protected String volaStratUndrId = null;
		protected String optiGatewayLocId = null;
		protected String trdSysCod = null;
	}

	/**
	 * ta111QuoteSpreadRec, repeated 0 ... variable times
	 */
	class Ta111QuoteSpreadRec {
		protected String spreadDaysMonth = null;
		protected String spreadTimeToExp = null;
		protected List<SpreadUndGrpTbl> spreadUndGrpTbls = new ArrayList<SpreadUndGrpTbl>();
	}

	/**
	 * spreadUndGrpTbl, repeated 1 ... 6 times
	 */
	class SpreadUndGrpTbl {
		protected String spreadBidPrice = null;
		protected String spreadTickValue = null;
		protected String spreadAbsPcntCode = null;
	}

	/**
	 * ta111PriceStepRec, repeated 0 ... variable times
	 */
	class Ta111PriceStepRec {
		protected List<PriceStepTbl> priceStepTbls = new ArrayList<PriceStepTbl>();
	}

	/**
	 * priceStepTbl, repeated 1 ... 11 times
	 */
	class PriceStepTbl {
		protected String priceStepCode = null;
		protected String upperLimitPrice = null;
		protected String priceStep = null;
	}

	/**
	 * ta111EbsHdrRec, repeated 0 ... variable times
	 */
	class Ta111EbsHdrRec {
		protected String noOfStreams = null;
	}

	/**
	 * ta111EbsDataRec, repeated 0 ... variable times
	 */
	class Ta111EbsDataRec {
		protected List<EbsDataTbl> ebsDataTbls = new ArrayList<EbsDataTbl>();
	}

	/**
	 * ebsDataTbl, repeated 1 ... 4 times
	 */
	class EbsDataTbl {
		protected String streamType = null;
		protected String streamService = null;
		protected String streamAddr = null;
		protected String streamPort = null;
		protected String mktDpth = null;
		protected String recoveryInterval = null;
	}

	/**
	 * ta111CntrRec, repeated 0 ... variable times
	 */
	class Ta111CntrRec {
		protected String cntrClasCod = null;
		protected String prodId = null;
		protected String cntrExpMthDat = null;
		protected String cntrExpYrDat = null;
		protected String cntrExerPrc = "0";
		protected String cntrVersNo = "0";
		protected String cntrStsCod = null;
		protected String expDat = null;
		protected String valorNum = null;
		protected String lepoFlg = null;
		protected String trdUnt = null;
		protected String strkPrcM = null;
		protected String trdUntShares = null;
		protected String trdUntCsh = null;
		protected String uniqueCntrId = null;
	}

	/**
	 * ta111SpinOffRec, repeated 0 ... variable times
	 */
	class Ta111SpinOffRec {
		protected String legNO = null;
		protected String prodId = null;
		protected List<CntrIdGrp> cntrIdGrps = new ArrayList<CntrIdGrp>();
		protected String isinCod = null;
		protected String cntrShrQty = null;
		protected String cntrCshSetlAmnt = null;
		protected String dlvLnd = null;
		protected String undrLstClsPrc = null;
		protected String undClsCurr = null;
	}

	/**
	 * cntrIdGrp, repeated 0 ... 1 times
	 */
	class CntrIdGrp {
		protected String cntrClasCod = null;
		protected String prodId = null;
		protected String cntrExpMthDat = null;
		protected String cntrExpYrDat = null;
		protected String cntrExerPrc = null;
		protected String cntrVersNo = null;
	}

	// members
	private String xmlFileName = null;

	public static void main(String[] args) {
		try {
			String inputXmlFile = null;
			String outputCSVFile = null;
			boolean rewriteXMLWithLineBreaks = false;
			switch (args.length) {
				case 2:
					inputXmlFile = args[0];
					outputCSVFile = args[1];
					break;
				case 3:
					inputXmlFile = args[0];
					outputCSVFile = args[1];
					rewriteXMLWithLineBreaks = "true".equalsIgnoreCase(args[2]);
					break;
				default:
					System.err.println("Number of args must be 2 or 3");
					System.exit(1);
					break;
			}

			new EurexAllActiveSeriesImportCSVGenerator(inputXmlFile).generateCsvFile(outputCSVFile, rewriteXMLWithLineBreaks);
		} catch (Exception e) {
			System.exit(1);
		}
	}

	public EurexAllActiveSeriesImportCSVGenerator(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public void generateCsvFile(String csvFileName, boolean rewriteXMLWithLineBreaks) throws Exception {
		boolean endElementReached = false;
		String startElementName = null;
		Element lastXmlElement = null;

		/* Flag to determine in which group reader is */
		boolean inTa111KeyGrp = false;
		boolean inTa111ProdRec = false;
		boolean inTa111QuoteSpreadRec = false;
		boolean inTa111QuoteSpreadUndGrpTbl = false;
		boolean inTa111PriceStepRec = false;
		boolean inTa111PriceStepTbl = false;
		boolean inTa111EbsHdrRec = false;
		boolean inTa111EbsDataRec = false;
		boolean inTa111EbsDataTbl = false;
		boolean inTa111CntrRec = false;
		boolean inTa111CntrCntrIdGrp = false;
		boolean inTa111CntrCntrDtlGrp = false;
		boolean inTa111SpinOffRec = false;
		boolean inTa111SpinOffCntrIdGrp = false;
		boolean inTa111SpinOffCntrDtlGrp = false;

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		FileWriter csvFileWriter = null;
		FileWriter rwXmlFileWriter = null;
		try {
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
					xmlFileName,
					new FileInputStream(xmlFileName));
			csvFileWriter = new FileWriter(csvFileName);
			if (rewriteXMLWithLineBreaks) {
				rwXmlFileWriter = new FileWriter(xmlFileName + ".rewrite");
			}

			csvFileWriter.write(CSV_HEADER_LINE + "\n");
			if (rewriteXMLWithLineBreaks) {
				rwXmlFileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
			}

			/* Current groups */
			Ta111Grp currentTa111Grp = null;
			Ta111ProdRec currentTa111ProdRec = null;
			Ta111QuoteSpreadRec currentTa111QuoteSpreadRec = null;
			SpreadUndGrpTbl currentSpreadUndGrpTbl = null;
			Ta111PriceStepRec currentTa111PriceStepRec = null;
			PriceStepTbl currentPriceStepTbl = null;
			Ta111EbsHdrRec currentTa111EbsHdrRec = null;
			Ta111EbsDataRec currentTa111EbsDataRec = null;
			EbsDataTbl currentEbsDataTbl = null;
			Ta111CntrRec currentTa111CntrRec = null;
			Ta111SpinOffRec currentTa111SpinOffRec = null;
			CntrIdGrp currentCntrIdGrp = null;

			while (xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				switch (xmlEvent.getEventType()) {

					case XMLEvent.START_ELEMENT:
						// *** START_ELEMENT ***
						endElementReached = false;
						StartElement startElement = xmlEvent.asStartElement();
						startElementName = startElement.getName().getLocalPart();
						if (rewriteXMLWithLineBreaks) {
							rwXmlFileWriter.write("\n<" + startElementName + ">");
						}

						if (startElementName.equals("ta111Grp")) {
							currentTa111Grp = new Ta111Grp();
						} else if (startElementName.equals("ta111KeyGrp")) {
							inTa111KeyGrp = true;
						} else if (startElementName.equals("ta111ProdRec")) {
							currentTa111ProdRec = new Ta111ProdRec();
							inTa111ProdRec = true;
						} else if (startElementName.equals("ta111QuoteSpreadRec")) {
							currentTa111QuoteSpreadRec = new Ta111QuoteSpreadRec();
							inTa111QuoteSpreadRec = true;
						} else if (startElementName.equals("spreadUndGrpTbl") && inTa111QuoteSpreadRec) {
							currentSpreadUndGrpTbl = new SpreadUndGrpTbl();
							inTa111QuoteSpreadUndGrpTbl = true;
						} else if (startElementName.equals("ta111PriceStepRec")) {
							currentTa111PriceStepRec = new Ta111PriceStepRec();
							inTa111PriceStepRec = true;
						} else if (startElementName.equals("priceStepTbl") && inTa111PriceStepRec) {
							currentPriceStepTbl = new PriceStepTbl();
							inTa111PriceStepTbl = true;
						} else if (startElementName.equals("ta111EbsHdrRec")) {
							currentTa111EbsHdrRec = new Ta111EbsHdrRec();
							inTa111EbsHdrRec = true;
						} else if (startElementName.equals("ta111EbsDataRec")) {
							currentTa111EbsDataRec = new Ta111EbsDataRec();
							inTa111EbsDataRec = true;
						} else if (startElementName.equals("ebsDataTbl") && inTa111EbsDataRec) {
							currentEbsDataTbl = new EbsDataTbl();
							inTa111EbsDataTbl = true;
						} else if (startElementName.equals("ta111CntrRec")) {
							currentTa111CntrRec = new Ta111CntrRec();
							inTa111CntrRec = true;
						} else if (startElementName.equals("cntrIdGrp") && inTa111CntrRec) {
							inTa111CntrCntrIdGrp = true;
						} else if (startElementName.equals("cntrDtlGrp") && inTa111CntrCntrIdGrp) {
							inTa111CntrCntrDtlGrp = true;
						} else if (startElementName.equals("ta111SpinOffRec")) {
							currentTa111SpinOffRec = new Ta111SpinOffRec();
							inTa111SpinOffRec = true;
						} else if (startElementName.equals("cntrIdGrp") && inTa111SpinOffRec) {
							currentCntrIdGrp = new CntrIdGrp();
							inTa111SpinOffCntrIdGrp = true;
						} else if (startElementName.equals("cntrDtlGrp") && inTa111SpinOffCntrIdGrp) {
							inTa111SpinOffCntrDtlGrp = true;
						}
						lastXmlElement = Element.START;
						break;

					case XMLEvent.END_ELEMENT:
						// *** END_ELEMENT ***
						EndElement endElement = xmlEvent.asEndElement();
						String endElementName = endElement.getName().getLocalPart();
						if (rewriteXMLWithLineBreaks) {
							if (lastXmlElement == Element.END) {
								rwXmlFileWriter.write("\n");
							}
							rwXmlFileWriter.write("</" + endElementName + ">");
						}

						if (endElementName.equals("ta111Grp")) {
							// Write CSV-File
							writeTa111GrpToCSV(csvFileWriter, currentTa111Grp);
						} else if (endElementName.equals("ta111KeyGrp")) {
							inTa111KeyGrp = false;
						} else if (endElementName.equals("ta111ProdRec")) {
							currentTa111Grp.ta111ProdRecs.add(currentTa111ProdRec);
							inTa111ProdRec = false;
						} else if (endElementName.equals("ta111QuoteSpreadRec")) {
							currentTa111Grp.ta111QuoteSpreadRecs.add(currentTa111QuoteSpreadRec);
							inTa111QuoteSpreadRec = false;
						} else if (endElementName.equals("spreadUndGrpTbl") && inTa111QuoteSpreadUndGrpTbl) {
							currentTa111QuoteSpreadRec.spreadUndGrpTbls.add(currentSpreadUndGrpTbl);
							inTa111QuoteSpreadUndGrpTbl = false;
						} else if (endElementName.equals("ta111PriceStepRec")) {
							currentTa111Grp.ta111PriceStepRecs.add(currentTa111PriceStepRec);
							inTa111PriceStepRec = false;
						} else if (endElementName.equals("priceStepTbl") && inTa111PriceStepTbl) {
							currentTa111PriceStepRec.priceStepTbls.add(currentPriceStepTbl);
							inTa111PriceStepTbl = false;
						} else if (endElementName.equals("ta111EbsHdrRec")) {
							currentTa111Grp.ta111EbsHdrRecs.add(currentTa111EbsHdrRec);
							inTa111EbsHdrRec = false;
						} else if (endElementName.equals("ta111EbsDataRec")) {
							currentTa111Grp.ta111EbsDataRecs.add(currentTa111EbsDataRec);
							inTa111EbsDataRec = false;
						} else if (endElementName.equals("ebsDataTbl") && inTa111EbsDataTbl) {
							currentTa111EbsDataRec.ebsDataTbls.add(currentEbsDataTbl);
							inTa111EbsDataTbl = false;
						} else if (endElementName.equals("ta111CntrRec")) {
							currentTa111Grp.ta111CntrRecs.add(currentTa111CntrRec);
							inTa111CntrRec = false;
						} else if (endElementName.equals("cntrIdGrp") && inTa111CntrRec) {
							inTa111CntrCntrIdGrp = false;
						} else if (endElementName.equals("cntrDtlGrp") && inTa111CntrCntrIdGrp) {
							inTa111CntrCntrDtlGrp = false;
						} else if (endElementName.equals("ta111SpinOffRec")) {
							currentTa111Grp.ta111SpinOffRecs.add(currentTa111SpinOffRec);
							inTa111SpinOffRec = false;
						} else if (endElementName.equals("cntrIdGrp") && inTa111SpinOffRec) {
							currentTa111SpinOffRec.cntrIdGrps.add(currentCntrIdGrp);
							inTa111SpinOffCntrIdGrp = false;
						} else if (endElementName.equals("cntrDtlGrp") && inTa111SpinOffCntrIdGrp) {
							inTa111SpinOffCntrDtlGrp = false;
						}

						lastXmlElement = Element.END;
						endElementReached = true;
						break;

					case XMLEvent.CHARACTERS:
						// *** CHARACTERS ***
						if (endElementReached) {
							break;
						}
						String characterData = xmlEvent.asCharacters().getData().trim();
						if (startElementName != null) {

							if (startElementName.equals("prodId")) {
								if (inTa111SpinOffCntrIdGrp) {
									currentCntrIdGrp.prodId = characterData;
								} else if (inTa111SpinOffRec && !inTa111SpinOffCntrIdGrp) {
									currentTa111SpinOffRec.prodId = characterData;
								} else if (inTa111CntrCntrIdGrp) {
									currentTa111CntrRec.prodId = characterData;
								} else if (inTa111KeyGrp) {
									currentTa111Grp.prodId = characterData;
								}
							} else if (startElementName.equals("prodLngNam")) {
								currentTa111Grp.prodLngNam = characterData;
							} else if (startElementName.equals("prodTypId")) {
								currentTa111Grp.prodTypId = characterData;
							} else if (startElementName.equals("isinCod")) {
								if (inTa111SpinOffRec) {
									currentTa111SpinOffRec.isinCod = characterData;
								} else if (inTa111ProdRec) {
									currentTa111ProdRec.isinCod = characterData;
								}
							} else if (startElementName.equals("undrIsin")) {
								currentTa111ProdRec.undrIsin = characterData;
							} else if (startElementName.equals("currTypCod")) {
								currentTa111ProdRec.currTypCod = characterData;
							} else if (startElementName.equals("mgnClsCod")) {
								currentTa111ProdRec.mgnClsCod = characterData;
							} else if (startElementName.equals("mgnStyle")) {
								currentTa111ProdRec.mgnStyle = characterData;
							} else if (startElementName.equals("exerStylTyp")) {
								currentTa111ProdRec.exerStylTyp = characterData;
							} else if (startElementName.equals("setlTypCod")) {
								currentTa111ProdRec.setlTypCod = characterData;
							} else if (startElementName.equals("finSetlmtTim")) {
								currentTa111ProdRec.finSetlmtTim = characterData;
							} else if (startElementName.equals("usTrdrFlg")) {
								currentTa111ProdRec.usTrdrFlg = characterData;
							} else if (startElementName.equals("blkTrdFlg")) {
								currentTa111ProdRec.blkTrdFlg = characterData;
							} else if (startElementName.equals("flxCntrTrdAllwdFlg")) {
								currentTa111ProdRec.flxCntrTrdAllwdFlg = characterData;
							} else if (startElementName.equals("minBlkSiz")) {
								currentTa111ProdRec.minBlkSiz = characterData;
							} else if (startElementName.equals("dispDcml")) {
								currentTa111ProdRec.dispDcml = characterData;
							} else if (startElementName.equals("exerPrcDcml")) {
								currentTa111ProdRec.exerPrcDcml = characterData;
							} else if (startElementName.equals("ticSiz")) {
								currentTa111ProdRec.ticSiz = characterData;
							} else if (startElementName.equals("ticVal")) {
								currentTa111ProdRec.ticVal = characterData;
							} else if (startElementName.equals("cntrClasCod")) {
								if (inTa111SpinOffCntrIdGrp) {
									currentCntrIdGrp.cntrClasCod = characterData;
								} else if (inTa111CntrCntrIdGrp) {
									currentTa111CntrRec.cntrClasCod = characterData;
								}
							} else if (startElementName.equals("cntrExpMthDat")) {
								if (inTa111SpinOffCntrDtlGrp) {
									currentCntrIdGrp.cntrExpMthDat = characterData;
								} else if (inTa111CntrCntrDtlGrp) {
									currentTa111CntrRec.cntrExpMthDat = characterData;
								}
							} else if (startElementName.equals("cntrExpYrDat")) {
								if (inTa111SpinOffCntrDtlGrp) {
									currentCntrIdGrp.cntrExpYrDat = characterData;
								} else if (inTa111CntrCntrDtlGrp) {
									currentTa111CntrRec.cntrExpYrDat = characterData;
								}
							} else if (startElementName.equals("cntrExerPrc")) {
								if (inTa111SpinOffCntrDtlGrp) {
									currentCntrIdGrp.cntrExerPrc = characterData;
								} else if (inTa111CntrCntrDtlGrp) {
									currentTa111CntrRec.cntrExerPrc = characterData;
								}
							} else if (startElementName.equals("cntrVersNo")) {
								if (inTa111SpinOffCntrDtlGrp) {
									currentCntrIdGrp.cntrVersNo = characterData;
								} else if (inTa111CntrCntrDtlGrp) {
									currentTa111CntrRec.cntrVersNo = characterData;
								}
							} else if (startElementName.equals("cntrStsCod")) {
								currentTa111CntrRec.cntrStsCod = characterData;
							} else if (startElementName.equals("expDat")) {
								currentTa111CntrRec.expDat = (characterData != null) ? characterData.replaceAll("-", "") : null;
							} else if (startElementName.equals("valorNum")) {
								currentTa111CntrRec.valorNum = characterData;
							} else if (startElementName.equals("lepoFlg")) {
								currentTa111CntrRec.lepoFlg = characterData;
							} else if (startElementName.equals("trdUnt")) {
								currentTa111CntrRec.trdUnt = characterData;
							} else if (startElementName.equals("trdUntShares")) {
								currentTa111CntrRec.trdUntShares = characterData;
							} else if (startElementName.equals("trdUntCsh")) {
								currentTa111CntrRec.trdUntCsh = characterData;
							} else if (startElementName.equals("cntrShrQty")) {
								currentTa111SpinOffRec.cntrShrQty = characterData;
							} else if (startElementName.equals("cntrCshSetlAmnt")) {
								currentTa111SpinOffRec.cntrCshSetlAmnt = characterData;
							} else if (startElementName.equals("dlvLnd")) {
								currentTa111SpinOffRec.dlvLnd = characterData;
							} else if (startElementName.equals("undrLstClsPrc")) {
								currentTa111SpinOffRec.undrLstClsPrc = characterData;
							} else if (startElementName.equals("prodExchAff")) {
								currentTa111ProdRec.prodExchAff = characterData;
							} else if (startElementName.equals("stlCurrTypCod")) {
								currentTa111ProdRec.stlCurrTypCod = characterData;
								// New Fields in Eurex 14.0
							} else if (startElementName.equals("matchTypeCode")) {
								currentTa111ProdRec.matchTypeCode = characterData;
							} else if (startElementName.equals("stratMatchCode")) {
								currentTa111ProdRec.stratMatchCode = characterData;
							} else if (startElementName.equals("oneSideQuoteAlwdFlg")) {
								currentTa111ProdRec.oneSideQuoteAlwdFlg = characterData;
							} else if (startElementName.equals("eqBidAskQtyReqrFlg")) {
								currentTa111ProdRec.eqBidAskQtyReqrFlg = characterData;
							} else if (startElementName.equals("maxPrice")) {
								currentTa111ProdRec.maxPrice = characterData;
							} else if (startElementName.equals("quoteMinQty")) {
								currentTa111ProdRec.quoteMinQty = characterData;
							} else if (startElementName.equals("fastMktQuoteMinQty")) {
								currentTa111ProdRec.fastMktQuoteMinQty = characterData;
							} else if (startElementName.equals("fastMarketQuotePcnt")) {
								currentTa111ProdRec.fastMarketQuotePcnt = characterData;
							} else if (startElementName.equals("undrIdCod")) {
								currentTa111ProdRec.undrIdCod = characterData;
							} else if (startElementName.equals("volaStratUndrId")) {
								currentTa111ProdRec.volaStratUndrId = characterData;
							} else if (startElementName.equals("optiGatewayLocId")) {
								currentTa111ProdRec.optiGatewayLocId = characterData;
							} else if (startElementName.equals("trdSysCod")) {
								currentTa111ProdRec.trdSysCod = characterData;
							} else if (startElementName.equals("spreadDaysMonth")) {
								currentTa111QuoteSpreadRec.spreadDaysMonth = characterData;
							} else if (startElementName.equals("spreadTimeToExp")) {
								currentTa111QuoteSpreadRec.spreadTimeToExp = characterData;
							} else if (startElementName.equals("spreadBidPrice")) {
								currentSpreadUndGrpTbl.spreadBidPrice = characterData;
							} else if (startElementName.equals("spreadTickValue")) {
								currentSpreadUndGrpTbl.spreadTickValue = characterData;
							} else if (startElementName.equals("spreadAbsPcntCode")) {
								currentSpreadUndGrpTbl.spreadAbsPcntCode = characterData;
							} else if (startElementName.equals("priceStepCode")) {
								currentPriceStepTbl.priceStepCode = characterData;
							} else if (startElementName.equals("upperLimitPrice")) {
								currentPriceStepTbl.upperLimitPrice = characterData;
							} else if (startElementName.equals("priceStep")) {
								currentPriceStepTbl.priceStep = characterData;
							} else if (startElementName.equals("noOfStreams")) {
								if (inTa111EbsHdrRec)
									currentTa111EbsHdrRec.noOfStreams = characterData;
							} else if (startElementName.equals("streamType")) {
								currentEbsDataTbl.streamType = characterData;
							} else if (startElementName.equals("streamService")) {
								currentEbsDataTbl.streamService = characterData;
							} else if (startElementName.equals("streamAddr")) {
								currentEbsDataTbl.streamAddr = characterData;
							} else if (startElementName.equals("streamPort")) {
								currentEbsDataTbl.streamPort = characterData;
							} else if (startElementName.equals("mktDpth")) {
								currentEbsDataTbl.mktDpth = characterData;
							} else if (startElementName.equals("recoveryInterval")) {
								currentEbsDataTbl.recoveryInterval = characterData;
							} else if (startElementName.equals("strkPrcM")) {
								currentTa111CntrRec.strkPrcM = characterData;
							} else if (startElementName.equals("uniqueCntrId")) {
								currentTa111CntrRec.uniqueCntrId = characterData;
							} else if (startElementName.equals("legNO")) {
								currentTa111SpinOffRec.legNO = characterData;
							} else if (startElementName.equals("undClsCurr")) {
								currentTa111SpinOffRec.undClsCurr = characterData;
							}
						}

						if (rewriteXMLWithLineBreaks) {
							rwXmlFileWriter.write(characterData);
						}

						lastXmlElement = Element.CHARACTERS;
						break;
					case XMLEvent.START_DOCUMENT:
						break;
					case XMLEvent.END_DOCUMENT:
						break;
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (csvFileWriter != null) {
				try {
					csvFileWriter.flush();
					csvFileWriter.close();
				} catch (IOException e) {
				}
			}
			if (rwXmlFileWriter != null) {
				try {
					rwXmlFileWriter.flush();
					rwXmlFileWriter.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private void writeTa111GrpToCSV(FileWriter csvFw, Ta111Grp grp) throws Exception {
		for (Ta111ProdRec prodRec : grp.ta111ProdRecs) {
			for (Ta111CntrRec cntrRec : grp.ta111CntrRecs) {
				writeToCSVFile(csvFw, grp.prodId, false);
				writeToCSVFile(csvFw, grp.prodLngNam, false);
				writeToCSVFile(csvFw, grp.prodTypId, false);

				writeToCSVFile(csvFw, prodRec.isinCod, false);
				writeToCSVFile(csvFw, prodRec.undrIsin, false);
				writeToCSVFile(csvFw, prodRec.currTypCod, false);
				writeToCSVFile(csvFw, prodRec.mgnClsCod, false);
				writeToCSVFile(csvFw, prodRec.mgnStyle, false);
				writeToCSVFile(csvFw, prodRec.exerStylTyp, false);
				writeToCSVFile(csvFw, prodRec.setlTypCod, false);
				writeToCSVFile(csvFw, prodRec.finSetlmtTim, false);
				writeToCSVFile(csvFw, prodRec.usTrdrFlg, false);
				writeToCSVFile(csvFw, prodRec.blkTrdFlg, false);
				writeToCSVFile(csvFw, prodRec.flxCntrTrdAllwdFlg, false);
				writeToCSVFile(csvFw, prodRec.minBlkSiz, false);
				writeToCSVFile(csvFw, prodRec.dispDcml, false);
				writeToCSVFile(csvFw, prodRec.exerPrcDcml, false);
				writeToCSVFile(csvFw, prodRec.ticSiz, false);
				writeToCSVFile(csvFw, prodRec.ticVal, false);

				writeToCSVFile(csvFw, cntrRec.cntrClasCod, false);
				writeToCSVFile(csvFw, cntrRec.prodId, false);
				writeToCSVFile(csvFw, cntrRec.cntrExpMthDat, false);
				writeToCSVFile(csvFw, cntrRec.cntrExpYrDat, false);

				if (cntrRec.cntrExerPrc != null) {
					try {
						int dispDcmlInt = Integer.parseInt((prodRec.exerPrcDcml != null) ? prodRec.exerPrcDcml : "0");
						if (dispDcmlInt != 0) {
							int dcmlPos = cntrRec.cntrExerPrc.length() - dispDcmlInt;
							// create missing zeros when dcmlPos < 0
							if (dcmlPos < 0) {
								StringBuffer missingzeros = new StringBuffer();
								for (; dcmlPos <= 0; dcmlPos++) {
									missingzeros.append("0");
								}
								cntrRec.cntrExerPrc = missingzeros + cntrRec.cntrExerPrc;
								dcmlPos = cntrRec.cntrExerPrc.length() - dispDcmlInt;
							}

							if (dcmlPos > 0 && !cntrRec.cntrExerPrc.contains(".")) {
								cntrRec.cntrExerPrc = cntrRec.cntrExerPrc.substring(0, dcmlPos)
										+ "."
										+ cntrRec.cntrExerPrc.substring(dcmlPos);
							} else if (dcmlPos == 0) {
								cntrRec.cntrExerPrc = "0." + cntrRec.cntrExerPrc;
							}
						}
					} catch (NumberFormatException e) {
						System.err.println("Cannot parse exerPrcDcml " + prodRec.exerPrcDcml + " as int.");
					}
				}
				writeToCSVFile(csvFw, cntrRec.cntrExerPrc, false);
				writeToCSVFile(csvFw, cntrRec.cntrVersNo, false);
				writeToCSVFile(csvFw, cntrRec.cntrStsCod, false);
				writeToCSVFile(csvFw, cntrRec.expDat, false);
				writeToCSVFile(csvFw, cntrRec.valorNum, false);
				writeToCSVFile(csvFw, cntrRec.lepoFlg, false);
				writeToCSVFile(csvFw, cntrRec.trdUnt, false);
				writeToCSVFile(csvFw, cntrRec.trdUntShares, false);
				writeToCSVFile(csvFw, cntrRec.trdUntCsh, true);
			}
		}
	}

	private void writeToCSVFile(FileWriter fw, String attrString, boolean linebreak) throws IOException {
		if (attrString != null) {
			fw.write(attrString);
		}
		if (linebreak) {
			fw.write("\n");
		} else {
			fw.write(";");
		}
	}
}
