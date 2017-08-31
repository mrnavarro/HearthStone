package cc3002;

/**
 * Represents a Shaman in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Shaman extends AbstractCard {

  public Shaman(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackShaman(this);
  }

  @Override
  public void normalAttack(Icard card) {
    card.setDmgReceived(card.getDmgReceived() + (this.getAttackPoints() / 3));
    card.setAttackPoints(card.getAttackPoints() - (this.getAttackPoints() / 3));
  }

  @Override
  public void doubleAttack(Icard card) {
    card.setDmgReceived(card.getDmgReceived() + (2 * this.getAttackPoints() / 3));
    card.setAttackPoints(card.getAttackPoints() - (2 * this.getAttackPoints() / 3));
  }

  @Override
  public void attackDruid(Icard card) {
    doubleAttack(card);
  }

  @Override
  public void attackWarlock(Icard card) {
    doubleAttack(card);
  }

}
