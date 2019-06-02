public class MoneyEntry {

    double money;
    double percentage;

    public MoneyEntry(double money, double percentage){
        this.money = money;
        this.percentage = percentage / 100;
    }

    public double getMoney(){
        return money;
    }

    public double getPercentage(){
        return percentage;
    }

    public double getMoneyAfterInterest(){
        double moneyAfterInterest = (money + money*percentage);
        return moneyAfterInterest;
    }

}
