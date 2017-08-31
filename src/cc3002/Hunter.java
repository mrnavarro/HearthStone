package cc3002;

/**
 * Represents a Hunter in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Hunter extends AbstractCard {

  public Hunter(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackHunter(this);
  }

  @Override
  public void attackShaman(Icard card) {
    doubleAttack(card);
  }

  @Override
  public void attackKnight(Icard card) {
    doubleAttack(card);
  }

}
