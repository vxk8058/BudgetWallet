public class ATM {
    public static final int MIN_ACCOUNT_LEN = 8;
    public static final int MAX_ACCOUNT_LEN = 17;
    public static final double MIN_AMT = 1.00;
    public static final double MAX_AMT = 5000.00;

    public static String[] existingAccounts = {"123456789", "112445798874", "456772234", "1111177593"};
    public static double[] currentBalances  = { 245.11, 4000.15, 1000.00, 450.96 };

    public static boolean checkAccountLen(String argAccount){
        if(argAccount.length() < MIN_ACCOUNT_LEN || argAccount.length() > MAX_ACCOUNT_LEN){
            return false;
        }
        return true;
    }

    public static boolean checkChar(String argAccount){
        for(int i = 0; i < argAccount.length(); ++i){
            if(!Character.isDigit(argAccount.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean accountExists(String argAccount){
        for(String exists : existingAccounts){
            if(argAccount.equals(exists)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkAmountLimit(double argAmt){
        if(argAmt < MIN_AMT || argAmt > MAX_AMT){
            return false;
        }
        return true;
    }

    public static boolean checkAmountUser(String argAccount, double argAmt){
        // in a real world case the user is already logged in, but since that functionality
        // is not present here, it will be implemented like this
        int sender = 0;
        for(int i = 0; i < existingAccounts.length; ++i){
            if(argAccount.equals(existingAccounts[i])){
                sender = i;
                break;
            }
        }

        if(argAmt > currentBalances[sender]){
            return false;
        }
        return true;
    }

    public static void sendMoney(String argAccount1, String argAccount2, double amount){
        int sender = 0, receiver = 0;
        for(int i = 0; i < existingAccounts.length; ++i){
            if(argAccount1.equals(existingAccounts[i])){
                sender = i;
            }
            if(argAccount2.equals(existingAccounts[i])){
                receiver = i;
            }
        }
        currentBalances[sender] -= amount;
        currentBalances[receiver] += amount;
    }

    public static String transfer(String sender, String receiver, double amount){
        //sender will always be a valid account id since the assumption
        //is that they are already logged in
        if(!checkChar(receiver)){
            return "Account Number must only contain digits.";
        }
        if(!checkAccountLen(receiver)){
            return "Account Number must be between 8 and 17 digits in length.";
        }
        if(!accountExists(receiver)){
            return "Provided Account Number does not exist.";
        }
        if(!checkAmountLimit(amount)){
            return "Transfer amount must be between $1.00 and $5000.00.";
        }
        if(!checkAmountUser(sender, amount)){
            return "Transfer amount cannot exceed sender balance.";
        }
        sendMoney(sender, receiver, amount);
        String formattedAmount = String.format("%.2f", amount);
        return formattedAmount + " successfully transferred to Account " + receiver;
    }
}
