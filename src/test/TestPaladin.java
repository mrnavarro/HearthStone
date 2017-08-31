package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPaladin {
  Icard anAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;
  Icard anotherPaladin;

  @Before
  public void setUp() throws Exception {
    anAssassin = new Assassin("Talon", 60, 8);
    aDruid = new Druid("Wololo", 80, 4);
    aHealer = new Healer("Mercy", 50, 6);
    aHunter = new Hunter("Gon", 80, 6);
    aKnight = new Knight("Kain", 150, 4);
    aMage = new Mage("Vivi", 50, 10);
    aPaladin = new Paladin("Cecil", 100, 7);
    aShaman = new Shaman("red", 70, 4);
    aWarlock = new Warlock("juan", 50, 5);
    anotherPaladin = new Paladin("pepito", 15, 9);
  }

  @Test
  public void testNormalAttack() {
    // 1/3 attack paladin -> 2
    anAssassin.setDmgReceived(20);
    aHunter.setDmgReceived(70);
    aShaman.setDmgReceived(40);

    assertEquals(20, anAssassin.getDmgReceived());
    assertEquals(70, aHunter.getDmgReceived());
    assertEquals(0, aKnight.getDmgReceived());
    assertEquals(0, aMage.getDmgReceived());
    assertEquals(40, aShaman.getDmgReceived());
    assertEquals(0, aWarlock.getDmgReceived());
    assertEquals(0, anotherPaladin.getDmgReceived());

    assertEquals(8, anAssassin.getAttackPoints());
    assertEquals(6, aHunter.getAttackPoints());
    assertEquals(4, aKnight.getAttackPoints());
    assertEquals(10, aMage.getAttackPoints());
    assertEquals(4, aShaman.getAttackPoints());
    assertEquals(5, aWarlock.getAttackPoints());
    assertEquals(9, anotherPaladin.getAttackPoints());

    aPaladin.attackTo(anAssassin);
    aPaladin.attackTo(aHunter);
    aPaladin.attackTo(aKnight);
    aPaladin.attackTo(aMage);
    aPaladin.attackTo(aShaman);
    aPaladin.attackTo(aWarlock);
    aPaladin.attackTo(anotherPaladin);

    // DmgReceived changes
    assertEquals(18, anAssassin.getDmgReceived());
    assertEquals(68, aHunter.getDmgReceived());
    assertEquals(0, aKnight.getDmgReceived());
    assertEquals(0, aMage.getDmgReceived());
    assertEquals(38, aShaman.getDmgReceived());
    assertEquals(0, aWarlock.getDmgReceived());
    assertEquals(0, anotherPaladin.getDmgReceived());

    // change AttackPoints
    assertEquals(10, anAssassin.getAttackPoints());
    assertEquals(8, aHunter.getAttackPoints());
    assertEquals(6, aKnight.getAttackPoints());
    assertEquals(12, aMage.getAttackPoints());
    assertEquals(6, aShaman.getAttackPoints());
    assertEquals(7, aWarlock.getAttackPoints());
    assertEquals(11, anotherPaladin.getAttackPoints());

    // if card is dead
    aHunter.setDmgReceived(90);

    assertEquals(8, aHunter.getAttackPoints());
    assertEquals(90, aHunter.getDmgReceived());
    assertTrue(aHunter.isDead());

    aPaladin.attackTo(aHunter);

    assertEquals(8, aHunter.getAttackPoints());
    assertEquals(90, aHunter.getDmgReceived());
    assertTrue(aHunter.isDead());

    // if paladin is dead
    aPaladin.setDmgReceived(100);
    aPaladin.isDead();
    assertEquals(10, anAssassin.getAttackPoints());
    assertEquals(18, anAssassin.getDmgReceived());
    aPaladin.attackTo(anAssassin);
    assertEquals(10, anAssassin.getAttackPoints());
    assertEquals(18, anAssassin.getDmgReceived());


  }

  @Test
  public void testDoubleAttack() {
    // 2/3 attack paladin -> 4

    aDruid.setDmgReceived(30);
    aHealer.setDmgReceived(15);

    assertEquals(30, aDruid.getDmgReceived());
    assertEquals(15, aHealer.getDmgReceived());

    assertEquals(4, aDruid.getAttackPoints());
    assertEquals(6, aHealer.getAttackPoints());

    aPaladin.attackTo(aDruid);
    aPaladin.attackTo(aHealer);

    assertEquals(26, aDruid.getDmgReceived());
    assertEquals(11, aHealer.getDmgReceived());

    assertEquals(8, aDruid.getAttackPoints());
    assertEquals(10, aHealer.getAttackPoints());
  }

}
