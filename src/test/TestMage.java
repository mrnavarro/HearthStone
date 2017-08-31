package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMage {
  Icard anAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;
  Icard anotherMage;

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
    anotherMage = new Mage("pepito", 15, 9);
  }

  @Test
  public void testNormalAttack() {
    assertEquals(0, anAssassin.getDmgReceived());
    assertEquals(0, aDruid.getDmgReceived());
    assertEquals(0, aHealer.getDmgReceived());
    assertEquals(0, aKnight.getDmgReceived());
    assertEquals(0, aShaman.getDmgReceived());
    assertEquals(0, aWarlock.getDmgReceived());
    assertEquals(0, anotherMage.getDmgReceived());

    aMage.attackTo(anAssassin);
    aMage.attackTo(aDruid);
    aMage.attackTo(aHealer);
    aMage.attackTo(aKnight);
    aMage.attackTo(aShaman);
    aMage.attackTo(aWarlock);
    aMage.attackTo(anotherMage);

    assertEquals(10, anAssassin.getDmgReceived());
    assertEquals(10, aDruid.getDmgReceived());
    assertEquals(10, aHealer.getDmgReceived());
    assertEquals(10, aKnight.getDmgReceived());
    assertEquals(10, aShaman.getDmgReceived());
    assertEquals(10, aWarlock.getDmgReceived());
    assertEquals(10, anotherMage.getDmgReceived());
  }

  @Test
  public void testDoubleAttack() {
    assertEquals(0, aHunter.getDmgReceived());
    assertEquals(0, aPaladin.getDmgReceived());

    aMage.attackTo(aHunter);
    aMage.attackTo(aPaladin);

    assertEquals(20, aHunter.getDmgReceived());
    assertEquals(20, aPaladin.getDmgReceived());
  }

}
