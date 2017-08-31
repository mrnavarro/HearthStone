package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestKnight {
  Icard anAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;
  Icard anotherKnight;

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
    anotherKnight = new Knight("pepito", 15, 6);
  }

  @Test
  public void testNormalAttack() {
    assertEquals(0, anAssassin.getDmgReceived());
    assertEquals(0, aDruid.getDmgReceived());
    assertEquals(0, aHealer.getDmgReceived());
    assertEquals(0, aHunter.getDmgReceived());
    assertEquals(0, aMage.getDmgReceived());
    assertEquals(0, aShaman.getDmgReceived());
    assertEquals(0, aWarlock.getDmgReceived());
    assertEquals(0, anotherKnight.getDmgReceived());;

    aKnight.attackTo(anAssassin);
    aKnight.attackTo(aDruid);
    aKnight.attackTo(aHealer);
    aKnight.attackTo(aHunter);
    aKnight.attackTo(aMage);
    aKnight.attackTo(aShaman);
    aKnight.attackTo(aWarlock);
    aKnight.attackTo(anotherKnight);

    assertEquals(4, anAssassin.getDmgReceived());
    assertEquals(4, aDruid.getDmgReceived());
    assertEquals(4, aHealer.getDmgReceived());
    assertEquals(4, aHunter.getDmgReceived());
    assertEquals(4, aMage.getDmgReceived());
    assertEquals(4, aShaman.getDmgReceived());
    assertEquals(4, aWarlock.getDmgReceived());
    assertEquals(4, anotherKnight.getDmgReceived());;
  }

  @Test
  public void testHalfAttack() {
    assertEquals(0, aPaladin.getDmgReceived());
    aKnight.attackTo(aPaladin);
    assertEquals(2, aPaladin.getDmgReceived());
  }

}
