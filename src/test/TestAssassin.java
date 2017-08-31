package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAssassin {
  Icard anAssassin;
  Icard anotherAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;

  @Before
  public void setUp() throws Exception {
    anAssassin = new Assassin("Talon", 60, 8);
    anotherAssassin = new Assassin("pedro", 50, 4);
    aDruid = new Druid("Wololo", 80, 4);
    aHealer = new Healer("Mercy", 50, 6);
    aHunter = new Hunter("Gon", 80, 6);
    aKnight = new Knight("Kain", 150, 4);
    aMage = new Mage("Vivi", 50, 10);
    aPaladin = new Paladin("Cecil", 100, 5);
    aShaman = new Shaman("red", 70, 4);
    aWarlock = new Warlock("juan", 50, 11);
  }

  @Test
  public void testNormalAttack() {
    assertEquals(0, anotherAssassin.getDmgReceived());
    assertEquals(0, aDruid.getDmgReceived());
    assertEquals(0, aHunter.getDmgReceived());
    assertEquals(0, aPaladin.getDmgReceived());
    assertEquals(0, aShaman.getDmgReceived());
    assertEquals(0, aWarlock.getDmgReceived());
    anAssassin.attackTo(anotherAssassin);
    anAssassin.attackTo(aDruid);
    anAssassin.attackTo(aHunter);
    anAssassin.attackTo(aPaladin);
    anAssassin.attackTo(aShaman);
    anAssassin.attackTo(aWarlock);
    assertEquals(8, anotherAssassin.getDmgReceived());
    assertEquals(8, aDruid.getDmgReceived());
    assertEquals(8, aHunter.getDmgReceived());
    assertEquals(8, aPaladin.getDmgReceived());
    assertEquals(8, aShaman.getDmgReceived());
    assertEquals(8, aWarlock.getDmgReceived());
  }

  @Test
  public void testDoubleAttack() {
    assertEquals(0, aMage.getDmgReceived());
    assertEquals(0, aHealer.getDmgReceived());
    anAssassin.attackTo(aMage);
    anAssassin.attackTo(aHealer);
    assertEquals(16, aMage.getDmgReceived());
    assertEquals(16, aHealer.getDmgReceived());
  }

  @Test
  public void testHalfAttack() {
    assertEquals(0, aKnight.getDmgReceived());
    anAssassin.attackTo(aKnight);
    assertEquals(4, aKnight.getDmgReceived());
  }

  @Test
  public void getterAndSettersTest() {
    assertEquals("Talon", anAssassin.getName());
    assertEquals(0, anAssassin.getDmgReceived());
    assertEquals(60, anAssassin.getLifePoints());
    assertEquals(8, anAssassin.getAttackPoints());
    anAssassin.setName("pepito");
    anAssassin.setDmgReceived(3);
    anAssassin.setLifePoints(5);
    anAssassin.setAttackPoints(50);
    assertEquals("pepito", anAssassin.getName());
    assertEquals(3, anAssassin.getDmgReceived());
    assertEquals(5, anAssassin.getLifePoints());
    assertEquals(50, anAssassin.getAttackPoints());
  }



}
