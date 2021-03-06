package de.htwg.se.model

import de.htwg.se.model.cardcomponent.cardbaseimlp.Card
import de.htwg.se.model.deckcomponent.deckbaseimpl.Deck
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class DeckSpec extends AnyWordSpec with Matchers {
  "The Deck" when {
    "new" should {
      val deck = new Deck()
      "be empty" in {
        deck.cards.size should be(0)
      }
      "have unapply" in {
        var deck = new Deck()
        deck = Deck(deck.initDeck())
        Deck.unapply(deck).get should be (deck.cards)
      }
    }}

  "The Deck" when {
    "initialized" should {
      var deck = new Deck()
      deck = Deck(deck.initDeck())
      "have 52 cards" in {
        deck.cards.size should be(52)
      }
    }}

  "The Deck" when {
    "a card is drawn" should {
      var deck = Deck(Vector(Card(false, 0), Card(false, 1), Card(false, 2), Card(false, 3), Card(false, 4)))
      val (newDeck, cards) = deck.drawCards(1)
      deck = newDeck
      "have draw card" in {
        deck.cards.size should be(4)
        cards(0) should be(Card(false, 4))
      }
    }}

  "The Deck" when {
    "multiple cards are drawn" should {
      var deck = Deck(Vector(Card(false, 0), Card(false, 1), Card(false, 2), Card(false, 3), Card(false, 4)))

      val (newDeck, cards) = deck.drawCards(4)
      deck = newDeck
      "have drawn multiple cards" in {
        deck.cards.size should be(1)
        cards.size should be(4)
      }
    }}

  "The Deck" when {
    "is reseted" should {
      var deck = new Deck(Vector(Card(false, 2), Card(false, 5)))
      "has only 2 cards before reset" in {
        deck.cards.size should be(2)
      }
      "have 52 cards" in {
        deck = deck.resetDeck()
        deck.cards.size should be (52)
      }
    }}

  "The Deck" when {
    "in Game " should {
      var deck = new Deck(Vector(Card(false, 0), Card(false, 1), Card(false, 2), Card(false, 3)))
      "check cards in Deck" in {
        deck.cardsInDeck should be(4)
      }
      "get all Cards" in {
        deck.getAllCards should be (Vector(Card(false, 0), Card(false, 1), Card(false, 2), Card(false, 3)))

      }
    }}
}