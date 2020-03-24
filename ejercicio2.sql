use fifa;
select count(personal_details.player_id) as jugadores from personal_details 
inner join other_details on personal_details.player_id=other_details.player_id where personal_details.age>25 && other_details.club='FC Bayern Munich';