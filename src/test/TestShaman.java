package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestShaman {
  Icard anAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;
  Icard anotherShaman;

  @Before
  public void setUp() throws Exception {
    anAssassin = new Assassin("Talon", 60, 8);
    aDruid = new Druid("Wololo", 80, 4);
    aHealer = new Healer("Mercy", 50, 6);
    aHunter = new Hunter("Gon", 80, 6);
    aKnight = new Knight("Kain", 150, 4);
    aMage = new Mage("Vivi", 50, 10);
    aPaladin = new Paladin("Cecil", 100, 7);
    aShaman = new Shaman("red", 70, 12);
    aWarlock = new Warlock("juan", 50, 5);
    anotherShaman = new Paladin("pepito", 15, 9);
  }

  @Test
  public void testNormalAttack() {
    // 1/3 attack shaman -> 4
    anAssassin.setDmgReceived(20);
    aHunter.setDmgReceived(70);
    aPaladin.setDmgReceived(40);

    assertEquals(20, anAssassin.getDmgReceived());
    assertEquals(70, aHunter.getDmgReceived());
    assertEquals(0, aKnight.getDmgReceived());
    assertEquals(0, aMage.getDmgReceived());
    assertEquals(40, aPaladin.getDmgReceived());
    assertEquals(0, anotherShaman.getDmgReceived());

    assertEquals(8, anAssassin.getAttackPoints());
    assertEquals(6, aHunter.getAttackPoints());
    assertEquals(4, aKnight.getAttackPoints());
    assertEquals(10, aMage.getAttackPoints());
    assertEquals(7, aPaladin.getAttackPoints());
    assertEquals(9, anotherShaman.getAttackPoints());

    aShaman.attackTo(anAssassin);
    aShaman.attackTo(aHunter);
    aShaman.attackTo(aKnight);
    aShaman.attackTo(aMage);
    aShaman.attackTo(aPaladin);
    aShaman.attackTo(anotherShaman);

    // DmgReceived changes
    assertEquals(24, anAssassin.getDmgReceived());
    assertEquals(74, aHunter.getDmgReceived());
    assertEquals(4, aKnight.getDmgReceived());
    assertEquals(4, aMage.getDmgReceived());
    assertEquals(44, aPaladin.getDmgReceived());
    assertEquals(4, anotherShaman.getDmgReceived());

    // change AttackPoints
    assertEquals(4, anAssassin.getAttackPoints());
    assertEquals(2, aHunter.getAttackPoints());
    assertEquals(0, aKnight.getAttackPoints());
    assertEquals(6, aMage.getAttackPoints());
    assertEquals(3, aPaladin.getAttackPoints());
    assertEquals(5, anotherShaman.getAttackPoints());

    // if card is dead
    aHunter.setDmgReceived(90);

    assertEquals(2, aHunter.getAttackPoints());
    assertEquals(90, aHunter.getDmgReceived());
    assertTrue(aHunter.isDead());
    aShaman.attackTo(aHunter);
    assertEquals(2, aHunter.getAttackPoints());
    assertEquals(90, aHunter.getDmgReceived());
    assertTrue(aHunter.isDead());

    // if AttackPoints will become negative
    assertEquals(3, aPaladin.getAttackPoints());
    aShaman.attackTo(aPaladin);
    assertEquals(0, aPaladin.getAttackPoints());


    // if paladin is dead
    aShaman.setDmgReceived(100);
    aShaman.isDead();
    assertEquals(4, anAssassin.getAttackPoints());
    assertEquals(24, anAssassin.getDmgReceived());
    aShaman.attackTo(anAssassin);
    assertEquals(4, anAssassin.getAttackPoints());
    assertEquals(24, anAssassin.getDmgReceived());
  }

  @Test
  public void testDoubleAttack() {
    // 2/3 attack paladin -> 8

    aDruid.setDmgReceived(30);
    aWarlock.setDmgReceived(15);

    assertEquals(30, aDruid.getDmgReceived());
    assertEquals(15, aWarlock.getDmgReceived());

    assertEquals(4, aDruid.getAttackPoints());
    assertEquals(5, aWarlock.getAttackPoints());

    aShaman.attackTo(aDruid);
    aShaman.attackTo(aWarlock);

    assertEquals(38, aDruid.getDmgReceived());
    assertEquals(23, aWarlock.getDmgReceived());

    assertEquals(0, aDruid.getAttackPoints());
    assertEquals(0, aWarlock.getAttackPoints());
  }

}
