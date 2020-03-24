use fifa;
select personal_details.player_name,player_stats.short_pass from personal_details 
inner join player_stats on personal_details.player_id=player_stats.player_id order by player_stats.short_pass desc;