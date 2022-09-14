

insert into public.plot (id, description, name, revision)
values  (1, 'First plot', 'Plot_1', 1),
        (2, 'PLot Too', 'PLot 2', 2);

insert into public.chapter (id, description, name, number, version)
values  (1, 'Mary had a little lamb', 'Mary', 32, 1.24),
        (2, 'London bridge is falling down', 'London', 2, 2.5),
        (3, 'Where the tree swallows swallows', 'Swallows trees', 13, 2.5);

insert into public.chapter_plots (chapter_id, plot_id)
values  (1, 2),
        (3, 2);

insert into public.character (id, first_name, last_name, role, sex, father, mother)
values  (4, 'Bart', 'Simpson', 3, 0, 1, 2),
        (3, 'Lisa', 'Simpson', 2, 1, 1, 2),
        (8, 'Homer', 'Simpson', null, null, null, null),
        (9, 'Montgomery', 'Burns', 1, 0, null, null),
        (10, 'Tommy', 'Hilfiger', 2, 0, 2, 1),
        (11, 'Betty', 'Boop', 4, 1, 9, 3),
        (6, 'Six', 'Inthemix', 3, 1, 4, null),
        (7, 'Luke', 'Lucky', 0, 0, null, null),
        (12, 'Homer', 'Simpson', 0, 0, 9, null),
        (13, 'Maya', 'De Bij', 2, 1, 1, 2),
        (14, 'Patch', 'Simpson', 1, 0, 10, 13),
        (5, 'Maggie', 'Simpson', 4, 1, 2, 1),
        (18, 'Sexy', 'Six', 4, 1, 10, 13),
        (20, 'Sexy', 'Six', 4, 1, 10, 13),
        (22, 'Sexy', 'Six', 4, 1, 10, 13),
        (23, null, null, null, null, null, null),
        (24, 'Sexy ', 'Six', 4, 1, 10, 13),
        (25, null, null, null, null, null, null),
        (15, 'Saxy ', 'Sax', 4, 1, 10, 13),
        (16, 'Soxy', 'Sox', 4, 1, 10, 13),
        (26, 'Suxy ', 'Sux', 0, 1, 1, 13),
        (27, null, null, null, null, null, null),
        (2, 'Marge', 'Simpson', 0, 2, null, null),
        (1, 'Homer', 'Simpson', 1, 0, null, null);

insert into public.characters_chapters (charac_id, chapter_id)
values  (4, 2),
        (2, 2),
        (3, 1),
        (3, 2);

insert into public.characters_plots (charac_id, plot_id)
values  (3, 2),
        (5, 3),
        (2, 1),
        (2, 2),
        (5, 2);

insert into public.plot (id, description, name, revision)
values  (1, 'First plot', 'Plot_1', 1),
        (2, 'PLot Too', 'PLot 2', 2),
        (3, 'plot episode', 'Plot3', 1);
