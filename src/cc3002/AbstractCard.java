package cc3002;

/**
 * Represents any card in the game
 * 
 * @author Marcelo Navarro
 *
 */
public abstract class AbstractCard implements Icard {
  private String Name;
  private int LifePoints;
  private int DmgReceived;
  private int AttackPoints;

  /**
   * Creates a card object
   * 
   * @param aName Name of the card
   * @param hp LifePoints of the card
   * @param aDmgReceived DmgReceived of the card
   * @param anAttackPoints AttackPoints of the card
   */
  public AbstractCard(String aName, int hp, int aDmgReceived, int anAttackPoints) {
    Name = aName;
    LifePoints = hp;
    DmgReceived = aDmgReceived;
    AttackPoints = anAttackPoints;
  }

  /**
   * creates a card object with 0 damage received
   * 
   * @param aName
   * @param hp
   * @param anAttackPoints
   */
  public AbstractCard(String aName, int hp, int anAttackPoints) {
    this(aName, hp, 0, anAttackPoints);
  }

  @Override
  public void attackTo(Icard card) {
    if (!(this.isDead() || card.isDead())) {
      card.attackedBy(this);
    }
  }

  @Override
  public void normalAttack(Icard card) {
    card.setDmgReceived(card.getDmgReceived() + this.AttackPoints);
  }

  @Override
  public void halfAttack(Icard card) {
    card.setDmgReceived(card.getDmgReceived() + (this.AttackPoints / 2));
  }

  @Override
  public void doubleAttack(Icard card) {
    card.setDmgReceived(card.getDmgReceived() + 2 * this.AttackPoints);
  }

  @Override
  public abstract void attackedBy(Icard card);

  @Override
  public boolean isDead() {
    return getLifePoints() <= getDmgReceived() ? true : false;
  }

  @Override
  public void attackAssassin(Icard card) {
    normalAttack(card);
  }

  @Override
  public void attackDruid(Icard card) {
    normalAttack(card);
  }

  @Override
  public void attackHealer(Icard card) {
    normalAttack(card);
  }

  @Override
  public void attackHunter(Icard card) {
    normalAttack(card);
  }

  @Override
  public void attackKnight(Icard card) {
    normalAttack(card);
  }

  @Override
  public void attackMage(Icard card) {
    normalAttack(card);
  }

  @Override
  public void attackPaladin(Icard card) {
    normalAttack(card);
  }

  @Override
  public void attackShaman(Icard card) {
    normalAttack(card);
  }

  @Override
  public void attackWarlock(Icard card) {
    normalAttack(card);
  }

  @Override
  public String getName() {
    return Name;
  }

  @Override
  public int getLifePoints() {
    return LifePoints;
  }

  @Override
  public int getDmgReceived() {
    return DmgReceived;
  }

  @Override
  public int getAttackPoints() {
    return AttackPoints;
  }

  @Override
  public void setName(String name) {
    Name = name;
  }

  @Override
  public void setLifePoints(int lifePoints) {
    LifePoints = lifePoints;
  }

  @Override
  public void setDmgReceived(int dmgReceived) {
    DmgReceived = dmgReceived;
    if (DmgReceived < 0) {
      DmgReceived = 0;
    }
  }

  @Override
  public void setAttackPoints(int attackPoints) {
    AttackPoints = attackPoints;
    if (AttackPoints < 0) {
      AttackPoints = 0;
    }
  }

}
