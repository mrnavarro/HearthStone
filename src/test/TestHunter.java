package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHunter {
  Icard anAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;
  Icard anotherHunter;

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
    anotherHunter = new Hunter("pepito", 15, 3);
  }

  @Test
  public void testNormalAttack() {
    assertEquals(0, anAssassin.getDmgReceived());
    assertEquals(0, aDruid.getDmgReceived());
    assertEquals(0, aHealer.getDmgReceived());
    assertEquals(0, aMage.getDmgReceived());
    assertEquals(0, aPaladin.getDmgReceived());
    assertEquals(0, aWarlock.getDmgReceived());
    assertEquals(0, anotherHunter.getDmgReceived());

    aHunter.attackTo(anAssassin);
    aHunter.attackTo(aDruid);
    aHunter.attackTo(aHealer);
    aHunter.attackTo(aMage);
    aHunter.attackTo(aPaladin);
    aHunter.attackTo(aWarlock);
    aHunter.attackTo(anotherHunter);

    assertEquals(6, anAssassin.getDmgReceived());
    assertEquals(6, aDruid.getDmgReceived());
    assertEquals(6, aHealer.getDmgReceived());
    assertEquals(6, aMage.getDmgReceived());
    assertEquals(6, aPaladin.getDmgReceived());
    assertEquals(6, aWarlock.getDmgReceived());
    assertEquals(6, anotherHunter.getDmgReceived());
  }

  @Test
  public void testDoubleAttack() {
    assertEquals(0, aKnight.getDmgReceived());
    assertEquals(0, aShaman.getDmgReceived());

    aHunter.attackTo(aKnight);
    aHunter.attackTo(aShaman);

    assertEquals(12, aKnight.getDmgReceived());
    assertEquals(12, aShaman.getDmgReceived());
  }

}
