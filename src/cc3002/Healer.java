package cc3002;

/**
 * Represents a Healer in HS
 * 
 * @author Marcelo Navarro
 *
 */
public class Healer extends AbstractCard {

  public Healer(String aName, int hp, int anAttackPoints) {
    super(aName, hp, anAttackPoints);
  }

  @Override
  public void attackedBy(Icard card) {
    card.attackHealer(this);
  }

  @Override
  public void normalAttack(Icard card) {
    card.setDmgReceived(card.getDmgReceived() - (this.getAttackPoints() / 2));
  }

  @Override
  public void attackWarlock(Icard card) {
    super.normalAttack(card);
  }

}
