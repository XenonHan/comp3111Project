package sample;


enum TowerType{NA, BasicTower, IceTower, Catapult,LaserTower}



public abstract class Tower {
	protected int MAX_MONSTER=100;//you may change latter
	protected double coordinateX;
	protected double coordinateY;
	protected double range;
	protected int power;
	protected TowerType type;
	protected boolean status;
	
	
	//monster data, the closest one
	protected Monster closestMon=null; 
	protected double closestMonDistance=0;
	
	Tower()
	{
		coordinateX=coordinateY=range=0; 
		status=false;
		status=false;
		power=0;
		type=TowerType.NA;
	}
	
	Tower(double x, double y, double range, TowerType type)
	{
		coordinateX=x;
		coordinateY=y;
		this.range=range;
		this.type=type;
		status=true;
		
		
	}
	

	
	//This function check whether the monster is in the attack range of tower
	boolean inAttackRange(Monster monster)
	{
		double tempX=monster.getX();
		double tempY=monster.getY();
		double tempRange=Math.sqrt(Math.pow((coordinateX-tempX),2)+Math.pow((coordinateY-tempY),2));
		
		if(tempRange<=range)
		{
			storeclosestMonster(monster,tempRange);
			return true;
		}
		return false;
	
		
	}
	
	
	//This function store/update the closest monster to the tower
	boolean storeclosestMonster(Monster monster,double tempRange)
	{
		if(closestMon==null ||tempRange<closestMonDistance)
		{
			closestMon=monster;
			closestMonDistance=tempRange;
			return true;
		}

		return false;
	
	}
	
	void newFrame() //Each tower should  this to update the locate storage before start next frame
	{	
		closestMon=null; 
		closestMonDistance=0;
	} 
	abstract boolean upgrade(); // you should handle player's recourse in arena 
	abstract boolean attackMonster();
	
}
