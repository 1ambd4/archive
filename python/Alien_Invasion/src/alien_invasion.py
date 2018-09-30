import pygame
from pygame.sprite import Group

from settings import Settings
from ship import Ship
from alien import Alien
from game_stats import GameStats
import game_functions as gf
from button import Button
from scoreboard import Scoreboard

def run_game():
    # Init game and create a background.
    pygame.init()
    # Create a instance of Settings.
    ai_settings = Settings()
    # Set screen size.
    screen = pygame.display.set_mode(
        (ai_settings.screen_width, ai_settings.screen_heigth))
    # Show caption.
    pygame.display.set_caption('Alien Invation')
    
    ship = Ship(ai_settings, screen)
    
    bullets = Group()
    
    aliens = Group()
    
    # Load a alien
    # alien = Alien(ai_settings, screen)
    #gf.create_fleet(ai_settings, screen, aliens)
    gf.create_fleet(ai_settings, screen, ship, aliens)
    
    stats = GameStats(ai_settings)
    
    sb = Scoreboard(ai_settings, screen, stats)
    
    play_button = Button(ai_settings, screen, "Play")
    
    # Game main loop.
    while True:
        
        # Monitor mouse and keyboard.
        gf.check_events(ai_settings, screen, stats, sb, play_button, ship, aliens, bullets)
        
        if stats.game_active:
            # Check ship status.
            ship.update()
            
            # Update and destory bullets
            gf.update_bullets(ai_settings, screen, stats, sb,  ship, aliens, bullets)
        
            gf.update_aliens(ai_settings, screen, stats, sb, ship, aliens, bullets)
        # Refresh screen.
        gf.update_screen(ai_settings, screen, stats, sb, ship, aliens, bullets, play_button)
         

run_game()