package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestWarlock {
  Icard anAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;
  Icard anotherWarlock;

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
    aWarlock = new Warlock("juan", 50, 11);
    anotherWarlock = new Warlock("pedro", 50, 4);
  }

  @Test
  public void testNormalAttack() {
    assertEquals(0, aDruid.getDmgReceived());
    assertEquals(0, aHealer.getDmgReceived());
    assertEquals(0, aHunter.getDmgReceived());
    assertEquals(0, aKnight.getDmgReceived());
    assertEquals(0, aMage.getDmgReceived());
    assertEquals(0, aPaladin.getDmgReceived());
    assertEquals(0, aShaman.getDmgReceived());
    assertEquals(0, anotherWarlock.getDmgReceived());

    aWarlock.attackTo(aDruid);
    aWarlock.attackTo(aHealer);
    aWarlock.attackTo(aHunter);
    aWarlock.attackTo(aKnight);
    aWarlock.attackTo(aMage);
    aWarlock.attackTo(aPaladin);
    aWarlock.attackTo(aShaman);
    aWarlock.attackTo(anotherWarlock);

    assertEquals(11, aDruid.getDmgReceived());
    assertEquals(11, aHealer.getDmgReceived());
    assertEquals(11, aHunter.getDmgReceived());
    assertEquals(11, aKnight.getDmgReceived());
    assertEquals(11, aMage.getDmgReceived());
    assertEquals(11, aPaladin.getDmgReceived());
    assertEquals(11, aShaman.getDmgReceived());
    assertEquals(11, anotherWarlock.getDmgReceived());
  }

  @Test
  public void testDoubleAttack() {
    assertEquals(0, anAssassin.getDmgReceived());
    aWarlock.attackTo(anAssassin);
    assertEquals(22, anAssassin.getDmgReceived());
  }

}
