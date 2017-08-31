package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDruid {
  Icard anAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;
  Icard anotherDruid;

  @Before
  public void setUp() throws Exception {
    anAssassin = new Assassin("Talon", 60, 8);
    aDruid = new Druid("Wololo", 80, 4);
    aHealer = new Healer("Mercy", 50, 6);
    aHunter = new Hunter("Gon", 80, 6);
    aKnight = new Knight("Kain", 150, 4);
    aMage = new Mage("Vivi", 50, 10);
    aPaladin = new Paladin("Cecil", 100, 5);
    aShaman = new Shaman("red", 70, 4);
    aWarlock = new Warlock("juan", 50, 5);
    anotherDruid = new Druid("pepito", 25, 7);
  }

  @Test
  public void testNormalAttack() {
    assertEquals(0, aHealer.getDmgReceived());
    assertEquals(0, aKnight.getDmgReceived());
    assertEquals(0, aMage.getDmgReceived());
    assertEquals(0, aPaladin.getDmgReceived());
    assertEquals(0, aShaman.getDmgReceived());
    assertEquals(0, aWarlock.getDmgReceived());
    assertEquals(0, anotherDruid.getDmgReceived());

    assertEquals(6, aHealer.getAttackPoints());
    assertEquals(4, aKnight.getAttackPoints());
    assertEquals(10, aMage.getAttackPoints());
    assertEquals(5, aPaladin.getAttackPoints());
    assertEquals(4, aShaman.getAttackPoints());
    assertEquals(5, aWarlock.getAttackPoints());
    assertEquals(7, anotherDruid.getAttackPoints());

    aDruid.attackTo(aHealer);
    aDruid.attackTo(aKnight);
    aDruid.attackTo(aMage);
    aDruid.attackTo(aPaladin);
    aDruid.attackTo(aShaman);
    aDruid.attackTo(aWarlock);
    aDruid.attackTo(anotherDruid);

    assertEquals(2, aHealer.getDmgReceived());
    assertEquals(2, aKnight.getDmgReceived());
    assertEquals(2, aMage.getDmgReceived());
    assertEquals(2, aPaladin.getDmgReceived());
    assertEquals(2, aShaman.getDmgReceived());
    assertEquals(2, aWarlock.getDmgReceived());
    assertEquals(2, anotherDruid.getDmgReceived());

    assertEquals(10, aHealer.getAttackPoints());
    assertEquals(8, aKnight.getAttackPoints());
    assertEquals(14, aMage.getAttackPoints());
    assertEquals(9, aPaladin.getAttackPoints());
    assertEquals(8, aShaman.getAttackPoints());
    assertEquals(9, aWarlock.getAttackPoints());
    assertEquals(11, anotherDruid.getAttackPoints());

  }

  @Test
  public void testHalfAttack() {
    assertEquals(0, anAssassin.getDmgReceived());
    assertEquals(0, aHunter.getDmgReceived());

    assertEquals(8, anAssassin.getAttackPoints());
    assertEquals(6, aHunter.getAttackPoints());

    aDruid.attackTo(anAssassin);
    aDruid.attackTo(aHunter);

    assertEquals(0, anAssassin.getDmgReceived());
    assertEquals(2, aHunter.getDmgReceived());

    assertEquals(10, anAssassin.getAttackPoints());
    assertEquals(6, aHunter.getAttackPoints());
  }

}
