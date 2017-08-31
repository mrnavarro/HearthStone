package test;

import cc3002.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHealer {
  Icard anAssassin;
  Icard aDruid;
  Icard aHealer;
  Icard aHunter;
  Icard aKnight;
  Icard aMage;
  Icard aPaladin;
  Icard aShaman;
  Icard aWarlock;
  Icard anotherHealer;

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
    anotherHealer = new Healer("pepito", 15, 6);
  }

  @Test
  public void testHealAttack() {
    anAssassin.setDmgReceived(30);
    aDruid.setDmgReceived(35);
    aHunter.setDmgReceived(70);
    aKnight.setDmgReceived(10);
    aMage.setDmgReceived(20);
    aPaladin.setDmgReceived(99);
    aShaman.setDmgReceived(16);
    anotherHealer.setDmgReceived(5);

    assertEquals(30, anAssassin.getDmgReceived());
    assertEquals(35, aDruid.getDmgReceived());
    assertEquals(70, aHunter.getDmgReceived());
    assertEquals(10, aKnight.getDmgReceived());
    assertEquals(20, aMage.getDmgReceived());
    assertEquals(99, aPaladin.getDmgReceived());
    assertEquals(16, aShaman.getDmgReceived());
    assertEquals(5, anotherHealer.getDmgReceived());

    aHealer.attackTo(anAssassin);
    aHealer.attackTo(aDruid);
    aHealer.attackTo(aHunter);
    aHealer.attackTo(aKnight);
    aHealer.attackTo(aMage);
    aHealer.attackTo(aPaladin);
    aHealer.attackTo(aShaman);
    aHealer.attackTo(anotherHealer);

    assertEquals(27, anAssassin.getDmgReceived());
    assertEquals(32, aDruid.getDmgReceived());
    assertEquals(67, aHunter.getDmgReceived());
    assertEquals(7, aKnight.getDmgReceived());
    assertEquals(17, aMage.getDmgReceived());
    assertEquals(96, aPaladin.getDmgReceived());
    assertEquals(13, aShaman.getDmgReceived());
    assertEquals(2, anotherHealer.getDmgReceived());

    // boundary case, DmgReceived>=0
    aHealer.attackTo(anotherHealer);
    assertEquals(0, anotherHealer.getDmgReceived());
    aHealer.attackTo(aKnight);
    aHealer.attackTo(aKnight);
    aHealer.attackTo(aKnight);
    assertEquals(0, aKnight.getDmgReceived());

    // boundary case, if a card is dead
    aKnight.setDmgReceived(aKnight.getLifePoints());
    assertEquals(150, aKnight.getDmgReceived());
    assertTrue(aKnight.isDead());
    aHealer.attackTo(aKnight);
    assertEquals(150, aKnight.getDmgReceived());
    assertTrue(aKnight.isDead());

  }

  @Test
  public void testAttackWarlock() {
    assertEquals(0, aWarlock.getDmgReceived());
    aHealer.attackTo(aWarlock);
    assertEquals(6, aWarlock.getDmgReceived());

  }

}
