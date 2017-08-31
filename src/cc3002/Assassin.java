package cc3002;

/**
 * Represents an Assassin in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Assassin extends AbstractCard {

  public Assassin(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackAssassin(this);
  }

  @Override
  public void attackHealer(Icard card) {
    doubleAttack(card);
  }

  @Override
  public void attackMage(Icard card) {
    doubleAttack(card);
  }

  @Override
  public void attackKnight(Icard card) {
    halfAttack(card);
  }

}
