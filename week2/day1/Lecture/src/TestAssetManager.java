
public class TestAssetManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Asset cadensAssets = new Asset();
		Asset bobsAssets = new Asset(4000, 2000);
		System.out.println(cadensAssets.getRetirementSum());
		bobsAssets.setRetirementSum(300);
		System.out.println(bobsAssets.getRetirementSum());	
		bobsAssets.withdrawalFromRetirement(2000);
		System.out.println(bobsAssets.getRetirementSum());
		System.out.println(Asset.getNumberOfAllAccounts());
		
		
	}


}
