use fifa;
select personal_details.player_name,other_details.club,player_stats.acceleration from personal_details 
inner join other_details on personal_details.player_id=other_details.player_id 
inner join player_stats on personal_details.player_id=player_stats.player_id where player_stats.acceleration>(select avg(acceleration) from player_stats) order by acceleration desc;