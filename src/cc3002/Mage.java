package cc3002;

/**
 * Represents a Mage in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Mage extends AbstractCard {

  public Mage(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackMage(this);
  }

  @Override
  public void attackHunter(Icard card) {
    doubleAttack(card);
  }

  @Override
  public void attackPaladin(Icard card) {
    doubleAttack(card);
  }

}
