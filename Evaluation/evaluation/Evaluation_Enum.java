package Evaluation1616.evaluation;

public class Evaluation_Enum
{
    public enum duty_comp_status_enum   {ACT, FTS, INACT, AT_ADSW};
    public enum promotion_status_enum   {REGULAR, FROCKED, SELECTED, SPOT};
    public enum report_occasion_enum    {PERIODIC, DETATCHMENT, PROMOTION, SPECIAL};
    public enum report_type_enum        {REGULAR, CONCURRENT}; 
    public enum billet_subcategory_enum {NA, BASIC, APPROVED, INDIV_AUG, CO_AFLOAT, CO_ASHORE,
                                         OIC, SEA_COMP, CRF, CANVASSER, RESIDENT, INTERN, INSTRUCTOR,
                                         STUDENT, RESAC1, RESAC6, SPECIAL};  //SPECIAL1-20
    public enum individual_recommend_enum {NOB, PROBLEMS, PROGRESSING, PROMOTABLE, MUST_PROMOTE,
                                           EARLY_PROMOTE};
}
