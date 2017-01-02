package lol;

import java.util.Random;

public class Hero extends Role{
	private Skill q =new Skill("q");
	private Skill w =new Skill("w");
	private Skill e =new Skill("e");
	private Skill r =new Skill("r");
	private Skill [] skills = {q,w,e,r};
	private Random rand = new Random();
	public Hero(String name,Camp camp) {
		super(name, camp);
		q.setSkillType(SkillType.ATTACT);
		q.setSkillValue(rand.nextInt(100));
		w.setSkillType(SkillType.PROTECT);
		w.setSkillValue(rand.nextInt(100));
		e.setSkillType(SkillType.ATTACT);
		e.setSkillValue(rand.nextInt(100));
		r.setSkillType(SkillType.PROTECT);
		r.setSkillValue(rand.nextInt(100));
	}
	
	@Override
	public void hit(Role role) {
		Skill skill = skills[rand.nextInt(4)];
		if(skill.getSkillType().equals(SkillType.ATTACT)){
			System.out.print(this.getName()+"使用攻击技能"+skill+",");
			role.beHit(this.getAttackPower());
		}
		else{
			System.out.print(this.getName()+"使用普通攻击,");
			role.beHit(this.getAttackPower());
		}
			
	}
	@Override
	public void beHit(int attack) {
		Skill skill = skills[rand.nextInt(4)];
		if(skill.getSkillType().equals(SkillType.PROTECT)){
			attack =attack- (int) (skill.getSkillValue()*0.4);
			System.out.println(this.getName()+"使用防御技能"+skill+",将伤害减少到"+attack);
			if(this.getBlood()-attack<=0){
				this.setBlood(0);
			}
			else
				this.setBlood(this.getBlood()-attack);
		}
		else{
			System.out.println(this.getName()+"没有使用任何防御技能，受到真实伤害"+attack);
			if(this.getBlood()-attack<=0){
				this.setBlood(0);
			}
			else
				this.setBlood(this.getBlood()-attack);
		}
	}	
	public void print(){
		System.out.println(this.getName()+"现在的血量为："+this.getBlood());
	}

}
