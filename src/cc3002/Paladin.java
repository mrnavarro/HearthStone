package cc3002;

/**
 * Represents a Paladin in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Paladin extends AbstractCard {

  public Paladin(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackPaladin(this);
  }

  @Override
  public void normalAttack(Icard card) {
    card.setDmgReceived(card.getDmgReceived() - (this.getAttackPoints() / 3));
    card.setAttackPoints(card.getAttackPoints() + (this.getAttackPoints() / 3));
  }

  @Override
  public void doubleAttack(Icard card) {
    card.setDmgReceived(card.getDmgReceived() - (2 * this.getAttackPoints() / 3));
    card.setAttackPoints(card.getAttackPoints() + (2 * this.getAttackPoints() / 3));
  }

  @Override
  public void attackDruid(Icard card) {
    doubleAttack(card);
  }

  @Override
  public void attackHealer(Icard card) {
    doubleAttack(card);
  }

}
