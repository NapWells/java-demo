package lol;

import java.util.Random;

public class Skill {
	private SkillType skillType;
	private int skillValue;
	private String skillName;
	
	public Skill(String skillName){
		this.skillName = skillName;
	}
	
	public void initSkillType(){
		skillType = SkillType.ATTACT;
	}
	public void initSkillValue(){
		Random rand = new Random();
		skillValue = rand.nextInt(100);
	}
	
	public SkillType getSkillType(){
		return skillType;
	}
	public void setSkillType(SkillType skillType){
		this.skillType = skillType;
	}
	public int getSkillValue(){
		return skillValue;
	}
	public void setSkillValue(int skillValue){
		this.skillValue = skillValue;
	}
	public void print(){
		if(skillType==SkillType.ATTACT)
			System.out.println("攻击技能");
		else
			System.out.println("防御技能");
	}
	public String toString(){
		return skillName;
	}
}
