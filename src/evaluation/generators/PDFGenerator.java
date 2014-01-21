package evaluation.generators;

import java.io.IOException;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFGenerator {
	
	  private String name, rate, desig, ssn;                                    //block 1-3 (ssn excluded)
	  private String duty_comp_status;                                          //block 5
	  private int UIC;                                                          //block 6
	  private String ship_station;                                              //block 7
	  private String promotion_status;                                          //block 8
	  private Date report_date;                                                 //block 9
	  //More than one occasion can apply, except that Special cannot be combined with another occasion.
	  //@TODO private String report_occasion_enum {PERIODIC, DETATCHMENT, PROMOTION, SPECIAL};  //block 10-13
	  private Date report_from;                                                 //block 14
	  private Date report_to;                                                   //block 15
	  private Boolean not_observed;                                             //block 16
	  //This field is used for Summary Group Comparison.
	  //@TODO private String report_type_enum {REGULAR, CONCURRENT};                            //block 17-19
	  //Enter specific PFA cycle identification information in block 29
	  private String physical_readiness;                                        //block 20
	  private String billet_subcategory;
	  private String reporting_senior;                                          //block 22
	  private String senior_grade;
	  private String senior_desig;
	  private String senior_title;                                              //block 25
	  private String senior_uic;                                                //block 26
	  private String senior_ssn;                                                //block 27
	  private String command_paragraph;                                         //block 28
	  //up to 14 characters or spaces
	  private String duty_abbrev;                                               //block 29 small box
	  private String duty_pfa_paragraph;                                        //block 29
	  private Date counsel_date;                                                //block 30
	  private String counselor;                                                 //block 31
	  private double individual_avg;                                            //block 40
	  private String career_recommend1, career_recommend2;                      //block 41
	  private String comments_on_performance;                                   //block 43
	  private String qualifications_achievements;                               //block 44
	  private Boolean retention;
	  private double summary_group_average;
	  
	  private PDDocument document;
	
	  public PDFGenerator()
	  {
		  try {
			document = new PDDocument();
			document.load("template.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public boolean loadTemplate()
	  {
		  return false;
	  }
}
