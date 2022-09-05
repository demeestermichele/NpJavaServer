
INSERT INTO public.chapter (id, description, name, number, version)
VALUES  (1, 'Mary had a little lamb',        'Mary',          32, 1.24),
        (2, 'London bridge is falling down', 'London',        2,  2.5),
        (3, 'Where the tree swallows swallows', 'Swallows trees',        13,  2.5);

insert into public.character (id, first_name, last_name, role, sex, father, mother)
values  (1, 'Homer',   'Simpson', 1, 0, null, null),
        (2, 'Marge',   'Simpson', 0, 1, null, null),
        (4, 'Bart',    'Simpson', 3, 0, 1, 2),
        (3, 'Lisa',    'Simpson', 2, 1, 1, 2),
        (5, 'Maggie',  'Simpson', 4, 1, 1, 2)
;


insert into public.plot (id, description, name, revision)
values  (1, 'First plot', 'Plot_1', 1),
        (2, 'PLot Too', 'PLot 2', 2),
        (3, 'plot episode', 'Plot3', 1);


insert into public.characters_chapters (charac_id, chapter_id)
values  (4, 2),
        (2, 2),
        (3, 1),
        (3, 2);

insert into public.characters_plots(charac_id, plot_id)
values  (3, 2),
        (5, 3),
        (2, 1),
        (2, 2),
        (5, 2);

insert into public.chapter_plots (chapter_id, plot_id)
values  (1, 2),
        (3, 2);
