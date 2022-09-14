//package ENUMS;
//
//import java.util.*;
//
//public enum TransferType {
//    CUSTOMER_TRANSFER {
//        public String getText() {
//            return "CU#";
//        }
//
//        public String getCodeText() {
//            return "AA";
//        }
//
//        public String getEvalText() {
//            return "CU";
//        }
//
//        public List<String> getTenants() {
//            return Arrays.asList("pm");
//        }
//
//        public AccountType getFromAccountType() {
//            return AccountType.CUSTOMER_ACCOUNT;
//        }
//
//        public AccountType getToAccountType() {
//            return AccountType.ESCROW_ACCOUNT;
//        }
//
//        public TransactionType getTransactionType() {
//            return TransactionType.CREDIT;
//        }
//
//
//    },
//
//
//    CUSTOMER_REFUND {
//        public String getText() {
//            return "CUST REF#";        }
//
//        public String getCodeText() {
//            return "AB";        }
//
//        public String getEvalText() {
//            return "CUST REF";        }
//
//        public List<String> getTenants() {
//            return Arrays.asList("pm");        }
//
//        public AccountType getFromAccountType() {
//            return AccountType.ESCROW_ACCOUNT;        }
//
//        public AccountType getToAccountType() {
//            return AccountType.CUSTOMER_ACCOUNT;        }
//
//        public TransactionType getTransactionType() {
//            return TransactionType.DEBIT;        }
//
//    },
//    COMMISSION_TDS {
//        public String getCodeText() {
//            return "AC";        }
//
//        public String getText() {
//            return "TDS CM#";        }
//
//        public String getEvalText() {
//            return "TDS CM";        }
//
//        public List<String> getTenants() {
//            return Arrays.asList("pm");        }
//
//        public AccountType getFromAccountType() {
//            return AccountType.ESCROW_ACCOUNT;        }
//
//        public AccountType getToAccountType() {
//            return AccountType.TAX_ACCOUNT;        }
//
//        public TransactionType getTransactionType() {
//            return TransactionType.DEBIT;        }
//    },
//    COMMISSION_TCS {
//        public String getCodeText() {
//            return "AD";        }
//
//        public String getText() {
//            return "TCS CM#";        }
//
//        public String getEvalText() {
//            return "TCS CM";        }
//
//        public List<String> getTenants() {
//            return Arrays.asList("pm");        }
//
//        public AccountType getFromAccountType() {
//            return AccountType.ESCROW_ACCOUNT;        }
//
//        public AccountType getToAccountType() {
//            return AccountType.TAX_ACCOUNT;        }
//
//        public TransactionType getTransactionType() {
//            return TransactionType.DEBIT;        }
//    },
//    COMMISSION_GST {
//        public String getCodeText() {
//            return "AE";        }
//
//        public String getText() {
//            return "GST CM#";        }
//
//        public String getEvalText() {
//            return "GST CM";        }
//
//        public List<String> getTenants() {
//            return Arrays.asList("pm");        }
//
//        public AccountType getFromAccountType() {
//            return AccountType.ESCROW_ACCOUNT;        }
//
//        public AccountType getToAccountType() {
//            return AccountType.TAX_ACCOUNT;        }
//
//        public TransactionType getTransactionType() {
//            return TransactionType.DEBIT;        }
//    },    // debit lines
//      COMMISSION {
//    public String getCodeText() {
//        return "AF";        }
//
//    public String getText() {
//        return "CM#";        }
//
//    public String getEvalText() {
//        return "CM";        }
//
//    public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//    public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//    public AccountType getToAccountType() {
//        return AccountType.CURRENT_ACCOUNT;        }
//
//    public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//    },
//
//    COMMISSION_REVERSAL_GST { // Credit Note
//          public String getCodeText() {
//        return "AG";
//    }
//
//public String getText() {
//        return "GST CM REV#";        }
//
//public String getEvalText() {
//        return "GST CM REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm", "scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    COMMISSION_REVERSAL_TCS { // Credit Note
//            public String getCodeText() {
//        return "AH";        }
//
//public String getText() {
//        return "TCS CM REV#";        }
//
//public String getEvalText() {
//        return "TCS CM REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm", "scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    COMMISSION_REVERSAL_TDS { // Credit Note
//              public String getCodeText() {
//        return "BQ";        }
//
//public String getText() {
//        return "TDS CM REV#";        }
//
//public String getEvalText() {
//        return "TDS CM REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm", "scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    COMMISSION_REVERSAL { // Credit Note
//          public String getCodeText() {
//        return "AI";        }
//
//public String getText() {
//        return "CM REV#";        }
//
//public String getEvalText() {
//        return "CM REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm", "scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.CURRENT_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },
//
//    BNB_WITHHOLDING {
//public String getCodeText() {
//        return "AJ";        }
//
//public String getText() {
//        return "WITH#";        }
//
//public String getEvalText() {
//        return "WITH";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.WITHHOLDING_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//        },    BNB_WITHHOLDING_REVERSAL {
//public String getCodeText() {
//        return "BP";        }
//
//public String getText() {
//        return "WITH REV#";        }
//
//public String getEvalText() {
//        return "WITH REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.WITHHOLDING_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//        },    BNB_PENALTY {
//public String getCodeText() {
//        return "AK";        }
//
//public String getText() {
//        return "PEN#";        }
//
//public String getEvalText() {
//        return "PEN";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.PENALTY_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//        },    BNB_PENALTY_REVERSAL {
//public String getCodeText() {
//        return "BR";        }
//
//public String getText() {
//        return "PEN#";        }
//
//public String getEvalText() {
//        return "PEN";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.PENALTY_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//        },    CONTRACTOR_TRANSFER_TDS {
//public String getCodeText() {
//        return "AL";        }
//
//public String getText() {
//        return "TDS CT#";        }
//
//public String getEvalText() {
//        return "TDS CT";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    CONTRACTOR_TRANSFER_TCS {
//public String getCodeText() {
//        return "AM";        }
//
//public String getText() {
//        return "TCS CT#";        }
//
//public String getEvalText() {
//        return "TCS CT";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    CONTRACTOR_TRANSFER {
//public String getCodeText() {
//        return "AN";        }
//
//public String getText() {
//        return "CT#";        }
//
//public String getEvalText() {
//        return "CT";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.CONTRACTOR_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    CONTRACTOR_TRANSFER_REVERSAL_TDS {
//public String getCodeText() {
//        return "AO";        }
//
//public String getText() {
//        return "TDS CT REV#";        }
//
//public String getEvalText() {
//        return "TDS CT REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    CONTRACTOR_TRANSFER_REVERSAL_TCS {
//public String getCodeText() {
//        return "AP";        }
//
//public String getText() {
//        return "TCS CT REV#";        }
//
//public String getEvalText() {
//        return "TCS CT REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    CONTRACTOR_TRANSFER_REVERSAL {
//public String getCodeText() {
//        return "AQ";        }
//
//public String getText() {
//        return "CT REV#";        }
//
//public String getEvalText() {
//        return "CT REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.CONTRACTOR_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    SCM_DIRECT_RECEIPT {
//public String getCodeText() {
//        return "AR";        }
//
//public String getText() {
//        return "CT PT#";        }
//
//public String getEvalText() {
//        return "CT PT";        }
//
//public AccountType getFromAccountType() {
//        return AccountType.CONTRACTOR_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.SCM_ACCOUNT;        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm", "scm");        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    BANK_CHARGES_DEBIT {
//public String getCodeText() {
//        return "BY";        }
//
//public String getText() {
//        return "DEBIT BANK CH#";        }
//
//public String getEvalText() {
//        return "DEBIT BANK CH";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm", "scm");        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    BANK_CHARGES_CREDIT {
//public String getCodeText() {
//        return "BZ";        }
//
//public String getText() {
//        return "CREDIT BANK CH#";        }
//
//public String getEvalText() {
//        return "CREDIT BANK CH";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm", "scm");        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    SCM_DEDUCTION_TDS {
//public String getCodeText() {
//        return "AT";        }
//
//public String getText() {
//        return "TDS SC#";        }
//
//public String getEvalText() {
//        return "TDS SC";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    SCM_DEDUCTION_TCS {
//public String getCodeText() {
//        return "AU";        }
//
//public String getText() {
//        return "TCS SC#";        }
//
//public String getEvalText() {
//        return "TCS SC";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    SCM_DEDUCTION {
//public String getCodeText() {
//        return "AV";        }
//
//public String getText() {
//        return "SC#";        }
//
//public String getEvalText() {
//        return "SC";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.SCM_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    SCM_DEDUCTION_REVERSAL_TDS {
//public String getCodeText() {
//        return "AY";        }
//
//public String getText() {
//        return "TDS SC REV#";        }
//
//public String getEvalText() {
//        return "TDS SC REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    SCM_DEDUCTION_REVERSAL_TCS {
//public String getCodeText() {
//        return "AZ";        }
//
//public String getText() {
//        return "TCS SC REV#";        }
//
//public String getEvalText() {
//        return "TCS SC REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    SCM_DEDUCTION_REVERSAL {
//public String getCodeText() {
//        return "BA";        }
//
//public String getText() {
//        return "SC REV#";        }
//
//public String getEvalText() {
//        return "SC REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.SCM_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    VENDOR_TRANSFER {
//public String getCodeText() {
//        return "BB";        }
//
//public String getText() {
//        return "VT#";        }
//
//public String getEvalText() {
//        return "VT";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.SCM_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.VENDOR_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    VENDOR_TRANSFER_TDS {
//public String getCodeText() {
//        return "BS";        }
//
//public String getText() {
//        return "TDS VT#";        }
//
//public String getEvalText() {
//        return "TDS VT";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("scm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.SCM_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },
//    CUSTOMER_DIRECT_TRANSFER {
//public String getCodeText() {
//        return "BC";        }
//
//public String getText() {
//        return "CDT#";        }
//
//public String getEvalText() {
//        return "CDT";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("");        }
//
////        public AccountType getFromAccountType() {//            return AccountType.SCM_ACCOUNT;//        }////        public AccountType getToAccountType() {//            return AccountType.VENDOR_ACCOUNT;//        }////        public TransactionType getTransactionType(){//            return TransactionType.DEBIT;//        }    },    STRUCTURAL_DESIGN_CHARGES {
//public String getCodeText() {
//        return "BD";        }
//
//public String getText() {
//        return "SDCT#";        }
//
//public String getEvalText() {
//        return "SDCT";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.PENALTY_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },
//
//    CROSS_TRANSFERS_DEBIT {
//public String getCodeText() {
//        return "BE";        }
//
//public String getText() {
//        return "CRT D#";        }
//
//public String getEvalText() {
//        return "CRT D";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    CROSS_TRANSFERS_CREDIT {
//public String getCodeText() {
//        return "BF";        }
//
//public String getText() {
//        return "CRT C#";        }
//
//public String getEvalText() {
//        return "CRT C";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    STRUCTURAL_DESIGN_CHARGES_TCS {
//public String getCodeText() {
//        return "BG";        }
//
//public String getText() {
//        return "TCS SDC#";        }
//
//public String getEvalText() {
//        return "TCS SDC";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    STRUCTURAL_DESIGN_CHARGES_TDS {
//public String getCodeText() {
//        return "BH";        }
//
//public String getText() {
//        return "TCS SDC#";        }
//
//public String getEvalText() {
//        return "TCS SDC";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    STRUCTURAL_DESIGN_CHARGES_GST {
//public String getCodeText() {
//        return "BI";        }
//
//public String getText() {
//        return "GST SDC#";        }
//
//public String getEvalText() {
//        return "GST SDC";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    VENDOR_SERVICE_TRANSFER {
//public String getCodeText() {
//        return "BJ";        }
//
//public String getText() {
//        return "VST#";        }
//
//public String getEvalText() {
//        return "VST";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.CURRENT_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    VENDOR_SERVICE_TRANSFER_GST {
//public String getCodeText() {
//        return "BK";        }
//
//public String getText() {
//        return "GST VST#";        }
//
//public String getEvalText() {
//        return "GST VST";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    VENDOR_SERVICE_TRANSFER_TDS {
//public String getCodeText() {
//        return "BL";        }
//
//public String getText() {
//        return "TDS VST#";        }
//
//public String getEvalText() {
//        return "TDS VST";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.CURRENT_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    VENDOR_SERVICE_TRANSFER_TCS {
//public String getCodeText() {
//        return "BM";        }
//
//public String getText() {
//        return "TCS VST#";        }
//
//public String getEvalText() {
//        return "TCS VST";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.CURRENT_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    PENDING_FLOOR_PLAN_CHARGES_DEBIT {
//public String getCodeText() {
//        return "BN";        }
//
//public String getText() {
//        return "PFPC#";        }
//
//public String getEvalText() {
//        return "PFPC";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.CURRENT_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    PENDING_FLOOR_PLAN_CHARGES_CREDIT {
//public String getCodeText() {
//        return "BO";        }
//
//public String getText() {
//        return "PFPC#";        }
//
//public String getEvalText() {
//        return "PFPC";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.CURRENT_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//        },    VENDOR_SERVICE_TRANSFER_REVERSAL {
//public String getCodeText() {
//        return "BT";        }
//
//public String getText() {
//        return "VST REV#";        }
//
//public String getEvalText() {
//        return "VST REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.CURRENT_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    VENDOR_SERVICE_TRANSFER_GST_REVERSAL {
//public String getCodeText() {
//        return "BU";        }
//
//public String getText() {
//        return "GST VST REV#";        }
//
//public String getEvalText() {
//        return "GST VST REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    VENDOR_SERVICE_TRANSFER_TDS_REVERSAL {
//public String getCodeText() {
//        return "BV";        }
//
//public String getText() {
//        return "TDS VST REV#";        }
//
//public String getEvalText() {
//        return "TDS VST REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    VENDOR_SERVICE_TRANSFER_TCS_REVERSAL {
//public String getCodeText() {
//        return "BX";        }
//
//public String getText() {
//        return "TCS VST REV#";        }
//
//public String getEvalText() {
//        return "TCS VST REV";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    CHANNEL_PARTNER_TRANSFER {
//public String getCodeText() {
//        return "CP";        }
//
//public String getText() {
//        return "CPT#";        }
//
//public String getEvalText() {
//        return "CPE";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.CHANNEL_PARTNER_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//        },    PRE_SALES_SOIL_TESTING_VENDOR_TRANSFER {
//public String getCodeText() {
//        return "STV";        }
//
//public String getText() {
//        return "SVT#";        }
//
//public String getEvalText() {
//        return "STE";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.CHANNEL_PARTNER_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//        },    PRE_SALES_DIGITAL_SURVEY_VENDOR_TRANSFER {
//public String getCodeText() {
//        return "SDV";        }
//
//public String getText() {
//        return "SDV#";        }
//
//public String getEvalText() {
//        return "SDE";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.CHANNEL_PARTNER_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//        },    PRE_SALES_STRUCTURAL_DRAWING_VENDOR_TRANSFER {
//public String getCodeText() {
//        return "SDD";        }
//
//public String getText() {
//        return "SDD#";        }
//
//public String getEvalText() {
//        return "SDDE";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.CHANNEL_PARTNER_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//
//        },    CHANNEL_PARTNER_REVERSAL_TRANSFER {
//public String getCodeText() {
//        return "CPR";        }
//
//public String getText() {
//        return "CPRT#";        }
//
//public String getEvalText() {
//        return "CPRE";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.CHANNEL_PARTNER_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//
//        },    CHANNEL_PARTNER_TDS {
//public String getCodeText() {
//        return "CPT";        }
//
//public String getText() {
//        return "CPT TDS#";        }
//
//public String getEvalText() {
//        return "CPTE";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    CHANNEL_PARTNER_GST {
//public String getCodeText() {
//        return "CPG";        }
//
//public String getText() {
//        return "CPT GST#";        }
//
//public String getEvalText() {
//        return "CPGE";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.TAX_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.DEBIT;        }
//        },    COLLECT_BOOKING_AMOUNT_TRANSFER {
//public String getCodeText() {
//        return "CBA";        }
//
//public String getText() {
//        return "CBA#";        }
//
//public String getEvalText() {
//        return "CBE";        }
//
//public List<String> getTenants() {
//        return Arrays.asList("pm");        }
//
//public AccountType getFromAccountType() {
//        return AccountType.CUSTOMER_ACCOUNT;        }
//
//
//public AccountType getToAccountType() {
//        return AccountType.ESCROW_ACCOUNT;        }
//
//public TransactionType getTransactionType() {
//        return TransactionType.CREDIT;        }
//
//        };