
public class Asset {
	private double retirementSum;
	private double otherAssetsTotal;
	private static int numberOfAccounts = 0;
	
//	constructor 
	public Asset() {
		this.retirementSum = 10;
		this.otherAssetsTotal = 0;
		numberOfAccounts++;
	}
	public Asset(double retirementSum, double otherAssetsTotal) {
		this.retirementSum = retirementSum;
		this.otherAssetsTotal = otherAssetsTotal;
		numberOfAccounts++;
	}
//	GETTERS 
//	public double getRetirementSum() {
//		return this.retirementSum;
//	}

	public double getRetirementSum() {
		return retirementSum;
	}

	public void setRetirementSum(double retirementSum) {
		this.retirementSum += retirementSum;
	}
	
	public void withdrawalFromRetirement(double amount) {
		if( (retirementSum - amount) >= 0 ) {
			retirementSum -= amount;
		} 
		else {
			System.out.println("Not enough funds");
		}
	}

	public double getOtherAssetsTotal() {
		return otherAssetsTotal;
	}

	public void setOtherAssetsTotal(double otherAssetsTotal) {
		this.otherAssetsTotal += otherAssetsTotal;
	}
	
	public static int getNumberOfAllAccounts() {
		return numberOfAccounts;
	}
	
	
	
//	SETTERS
//	public void setRetirementSum(double retirementSum) {
//		this.retirementSum += retirementSum;
//	}
//	
	
	
}
