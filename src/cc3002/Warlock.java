package cc3002;

/**
 * Represents a Warlock in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Warlock extends AbstractCard {

  public Warlock(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackWarlock(this);
  }

  @Override
  public void attackAssassin(Icard card) {
    doubleAttack(card);
  }

}
