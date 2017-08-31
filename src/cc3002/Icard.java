package cc3002;

/**
 * Interface for all cards in Hearthstone
 * 
 * @author Marcelo Navarro
 *
 */
public interface Icard {

  /**
   * to attack any card (except itself)
   * 
   * @param card Card that is attacked
   */
  public void attackTo(Icard card);

  /**
   * Add attackpoints to the DmgReceived of card in the argument
   * 
   * @param card Card that is attacked
   */
  public void normalAttack(Icard card);

  /**
   * Add half of attackpoints to the DmgReceived of card in the argument
   * 
   * @param card Card that is attacked
   */
  public void halfAttack(Icard card);

  /**
   * Add double of attackpoints to the DmgReceived of card in the argument
   * 
   * @param card Card that is attacked
   */
  public void doubleAttack(Icard card);

  /**
   * call any attack method (normal, half or doubleAttack) and use double dispatch
   * 
   * @param card The card that is attacking
   */
  public void attackedBy(Icard card);

  /**
   * Says if a card is dead or not
   * 
   * @return true if card is dead or false if card is alive
   */
  public boolean isDead();

  /**
   * Attacks to Assassin
   * 
   * @param card The card that is being attacked, the card is a Assassin
   */
  public void attackAssassin(Icard card);

  /**
   * Attacks to Druid
   * 
   * @param card The card that is being attacked, the card is a Druid
   */
  public void attackDruid(Icard card);

  /**
   * Attacks to Healer
   * 
   * @param card The card that is being attacked, the card is a Healer
   */
  public void attackHealer(Icard card);

  /**
   * Attacks to Hunter
   * 
   * @param card The card that is being attacked, the card is a Hunter
   */
  public void attackHunter(Icard card);

  /**
   * Attacks to Knight
   * 
   * @param card The card that is being attacked, the card is a Knight
   */
  public void attackKnight(Icard card);

  /**
   * Attacks to Mage
   * 
   * @param card The card that is being attacked, the card is a mage
   */
  public void attackMage(Icard card);

  /**
   * Attacks to Paladin
   * 
   * @param card The card that is being attacked, the card is a paladin
   */
  public void attackPaladin(Icard card);

  /**
   * Attacks to Shaman
   * 
   * @param card The card that is being attacked, the card is a shaman
   */
  public void attackShaman(Icard card);

  /**
   * Attacks warlock
   * 
   * @param card The card that is being attacked, the card is a Warlock
   */
  public void attackWarlock(Icard card);

  /**
   * returns the name
   * 
   * @return current Name
   */
  public String getName();

  /**
   * returns the damage received
   * 
   * @return current Damage received
   */
  public int getDmgReceived();

  /**
   * returns the life points
   * 
   * @return current Life Points
   */
  public int getLifePoints();

  /**
   * returns the attack points
   * 
   * @return current Attack Points
   */
  public int getAttackPoints();

  /**
   * sets the damage received
   * 
   * @param dmgReceived new value for DmgReceived
   */
  public void setDmgReceived(int dmgReceived);

  /**
   * sets the name
   * 
   * @param name new value for Name
   */
  public void setName(String name);

  /**
   * sets the attack points
   * 
   * @param attackPoints new value for AttackPoints
   */
  public void setAttackPoints(int attackPoints);

  /**
   * set the life points
   * 
   * @param lifePoints new value for LifePoints
   */
  public void setLifePoints(int lifePoints);

}
