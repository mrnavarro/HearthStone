package cc3002;

/**
 * Represents a Knight in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Knight extends AbstractCard {

  public Knight(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackKnight(this);
  }

  @Override
  public void attackPaladin(Icard card) {
    halfAttack(card);
  }

}
