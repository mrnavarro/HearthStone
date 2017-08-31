package cc3002;

/**
 * Represents a Druid in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Druid extends AbstractCard {

  public Druid(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackDruid(this);
  }

  /**
   * Add attack points to the attack points of card in the argument
   * 
   * @param card The card that will increase their attack points
   */
  public void normalAtkUp(Icard card) {
    card.setAttackPoints(card.getAttackPoints() + this.getAttackPoints());
  }

  /**
   * Add half of attack points to the attack points of card in the argument
   * 
   * @param card The card that will increase their attack points
   */
  public void halfAtkUp(Icard card) {
    card.setAttackPoints(card.getAttackPoints() + (this.getAttackPoints() / 2));
  }

  @Override
  public void normalAttack(Icard card) {
    normalAtkUp(card);
    halfAttack(card);
  }

  @Override
  public void attackAssassin(Icard card) {
    halfAtkUp(card);
  }

  @Override
  public void attackHunter(Icard card) {
    halfAttack(card);
  }

}
