insert into ACCESSORY (ID, INVENTORY_NUMBER, NAME, ADDITIONAL_NAME, DEFAULT_PHOTO, DEFAULT_GALLERY, STATUS, LOCATION, DIMENSIONS, MATERIAL, DESCRIPTION, COMMENTS) values (2, 'ACC002', 'bow', 'my first bow', 25, 10, 'DEPOSITED', 1, ARRAY [30, 31], ARRAY [21, 22, 23], 'My first bow', 'Really a piece of junk')
insert into ACCESSORY (ID, INVENTORY_NUMBER, NAME, ADDITIONAL_NAME, DEFAULT_PHOTO, DEFAULT_GALLERY, STATUS, LOCATION, DIMENSIONS, MATERIAL, DESCRIPTION, COMMENTS) values (3, 'ACC003', 'chin rest', 'ancient chin rest', 26, 27, 'DEPOSITED', 1, ARRAY [33, 34], ARRAY [25, 26, 27], 'Really an ancient chin rest', 'Not worth a mention')

insert into ACQUISITION (ID, ACQUISITION_TYPE, ACQUISITION_DATE, ACQUIRED_FROM, ACQUIRED_ITEMS, DEFAULT_GALLERY, GALLERIES, AUDIO, VIDEO, FILES, LINKS, DESCRIPTION, COMMENTS) values (2, 'DONATION', '2. 2. 2222', 4, ARRAY [2, 3, 4, 5], 4, ARRAY [4, 5], ARRAY [4, 5], ARRAY [4, 5], ARRAY [4, 5], ARRAY [4, 5], 'Donation from an old man', 'That was a lucky day')
insert into ACQUISITION (ID, ACQUISITION_TYPE, ACQUISITION_DATE, ACQUIRED_FROM, ACQUIRED_ITEMS, DEFAULT_GALLERY, GALLERIES, AUDIO, VIDEO, FILES, LINKS, DESCRIPTION, COMMENTS) values (3, 'PURCHASE', '1, 1. 1111', null, ARRAY [8], null, null, null, null, null, null, 'Purchase that happened a long time ago in a galaxy far, far away....', 'I cannot recall any details')

insert into ADDRESS (ID, STREET1, STREET2, CITY, ZIP, PROVINCE, COUNTRY, TELEPHONE, EMAIL) values (2, 'Karmelitska 2/4', null, 'Prague', '118 00', 'Prague D.C.', 'Czech Republic', '+420224497707', 'cmh@nm.cz')
insert into ADDRESS (ID, STREET1, STREET2, CITY, ZIP, PROVINCE, COUNTRY, TELEPHONE, EMAIL) values (3, '10 Downing Street', null, 'London', 'SW1A 2AA', null, 'Great Britain', null, 'write_to_your_pm@gov.uk')
insert into ADDRESS (ID, STREET1, STREET2, CITY, ZIP, PROVINCE, COUNTRY, TELEPHONE, EMAIL) values (101, 'Městečko 27', null, 'Velké Němčice', '691 63', null, 'Česká Republika', '+420519417285', 'support@furchguitars.com')

insert into AUDIO (ID, FILE_NAME, LENGTH, NAME, TYPE, DESCRIPTION, COMMENTS) values (2, '14_String_Quintet_in_C_Major.mp3', '9:24', 'Minuetto dei Ciechi', 'AUDIO', '3rd movement from Op. 30 Musica notturna delle strade di Madrid', 'It''s really a film music')
insert into AUDIO (ID, FILE_NAME, LENGTH, NAME, TYPE, DESCRIPTION, COMMENTS) values (3, '20230219-140231.mp3', '4:32', 'Tiebel violinophone sample', 'AUDIO', 'First record of newly restaured violinophone by Willie Tiebel', null)

insert into CONDITIONS (ID, CONDITION_STATUS, COMPACTNESS, DESCRIPTION, COMMENTS) values (2, 'NEW', 'COMPLETE', 'Funglovka', 'Luckily no transport damage')
insert into CONDITIONS (ID, CONDITION_STATUS, COMPACTNESS, DESCRIPTION, COMMENTS) values (3, 'FRAGMENTED', 'PARTIAL', 'Nasračky', 'Drunk and drop')

insert into DIMENSION (ID, DIMENSION_TYPE, DIMENSION_VALUE, UNIT, DESCRIPTION, COMMENTS) values (2, 'ANGLE', 90.0, 'DEG', 'Right angle', 'That is right')
insert into DIMENSION (ID, DIMENSION_TYPE, DIMENSION_VALUE, UNIT, DESCRIPTION, COMMENTS) values (3, 'DIAMETER', 12756000.0, 'M', 'Diameter of Earth', 'Radius is only half of it')

insert into EXTENSION (ID, NAME, TEMPLATE_NAME, DESCRIPTION, COMMENTS) values (22, 'Baritone ukulele - standard', 'default_strings', 'String setup of standard baritone ukulele with low D', null)
insert into EXTENSION (ID, NAME, TEMPLATE_NAME, DESCRIPTION, COMMENTS) values (23, 'StringsExtension', 'default_strings', 'Some strings', 'So far I have no other type of Extension')

insert into FILE (ID, FILE_NAME, NAME, TYPE, DESCRIPTION, COMMENTS) values (2, 'manual.pdf', 'Hurdy-gurdy for dummies', 'FILE', 'Play techniques and maintenance documentation', 'It''s really for total dummies')
insert into FILE (ID, FILE_NAME, NAME, TYPE, DESCRIPTION, COMMENTS) values (3, 'sheet.pdf', 'Star Wars symphony sheet music', 'FILE', 'Symphony composed by John Williams', null)

insert into GRAPHICS (ID, GRAPHICS_TYPE, FILE_NAME, NAME, TYPE, DESCRIPTION, COMMENTS, RESOLUTION, ACQUIRED) values (22, 'Image', 'panjoD2_chords.jpg', 'Panjo model D2 chords cheat sheet', 'IMAGE', 'Cheat sheet of common chords played on panjo model D2', null, '1920x1080', null)
insert into GRAPHICS (ID, GRAPHICS_TYPE, FILE_NAME, NAME, TYPE, DESCRIPTION, COMMENTS, RESOLUTION, ACQUIRED) values (23, 'Drawing', '4_strings_panjo_schema.jpg', '4-stringed panjo', 'DRAWING', 'String schema of a common 4-stringed panjo', null, '600x400', null)

insert into IMAGE_GALLERY (ID, NAME, IMAGES, DESCRIPTION, COMMENTS) values (2, 'Portfolio of Francisco Farina', ARRAY [101, 102, 103, 104, 105], 'Photo collection of Timples Canario made by Francisco Farina luthier from Tenerife', 'Name Farina should have contained tilda char over ''n'' char, but I had problem with SQL insert')
insert into IMAGE_GALLERY (ID, NAME, IMAGES, DESCRIPTION, COMMENTS) values (3, 'Empty gallery', ARRAY [], 'An empty but non-null gallery', null)

insert into ITEM (ID, INVENTORY_NUMBER, NAME, ADDITIONAL_NAME, CATEGORY,DEFAULT_PHOTO, STATUS, DESCRIPTION, LABELS, DRAWINGS, DIMENSIONS, MATERIAL, LOCATION, OWNER, CURRENT_CONDITIONS, COMMENTS, MANUFACTURE_DATE, MANUFACTURERS, ACQUISITION, ACQUISITION_CONDITION, DEFAULT_GALLERY, GALLERIES, AUDIO, VIDEO, FILES, LINKS, EXTENSIONS, ACCESSORIES) values (2001, 'I2001', 'Panjo', 'Panjo model D2', '/musical instruments/chordophones/plucked', 2001, 'SOLD', 'Improved version of model D', ARRAY ['panjo'], ARRAY [2002], ARRAY [2001, 2002, 2003, 2004, 2005], ARRAY [2001, 2002, 2003, 2004, 2005], 21, 21, 2002, null, '2021', ARRAY [21], 2001, 2001, 2001, ARRAY [2001], null, null, null, null, ARRAY [2001], null)
insert into ITEM (ID, INVENTORY_NUMBER, NAME, ADDITIONAL_NAME, CATEGORY,DEFAULT_PHOTO, STATUS, DESCRIPTION, LABELS, DRAWINGS, DIMENSIONS, MATERIAL, LOCATION, OWNER, CURRENT_CONDITIONS, COMMENTS, MANUFACTURE_DATE, MANUFACTURERS, ACQUISITION, ACQUISITION_CONDITION, DEFAULT_GALLERY, GALLERIES, AUDIO, VIDEO, FILES, LINKS, EXTENSIONS, ACCESSORIES) values (23, 'I0023', 'Item', 'Some random item', '/other items/other', null, 'DISCARDED', 'Something not worth a mention', ARRAY ['bullshit'], null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)

insert into LINK (ID, FILE_NAME, NAME, TYPE, DESCRIPTION, COMMENTS, URL) values (2, null, 'Thomann e-shop', 'LINK', 'Link to e-shop of the biggest music shop in Europe', null, 'https://www.thomann.de/intl/index.html')
insert into LINK (ID, FILE_NAME, NAME, TYPE, DESCRIPTION, COMMENTS, URL) values (3, null, 'Some link', 'LINK', 'Some unimportant web', null, 'https://www.cosi.kdesi.cz')

insert into LOCATION (ID, NAME, ADDRESS, DESCRIPTION, COMMENTS) values (2, 'Czech Museum of Music', 2, 'Part of the Czech National Museum devoted to music and musical instruments', null)
insert into LOCATION (ID, NAME, ADDRESS, DESCRIPTION, COMMENTS) values (3, 'Secret location', 666, 'Secret location where all my instruments are hidden from the outer world', null)

insert into MATERIAL (ID, CATEGORY, TYPE, DESCRIPTION, COMMENTS) values (2, 'METAL', 'Heavy metal', 'It''s rather a death metal', 'Death metal is not death!!!')
insert into MATERIAL (ID, CATEGORY, TYPE, DESCRIPTION, COMMENTS) values (3, 'OTHER', 'Unknown material', 'Nobody can determine what it really is', null)

insert into STRING_INFO (ID, STRING_ORDER, PITCH, THICKNESS, MATERIAL, DESCRIPTION, COMMENTS) values (2, 3, 'A4', 6552, 442, 'silver coated violin string', null)
insert into STRING_INFO (ID, STRING_ORDER, PITCH, THICKNESS, MATERIAL, DESCRIPTION, COMMENTS) values (3, 2, 'D4', 6852, 294, 'silver coated violin string', null)

insert into STRINGS (ID, STRINGS, SCHEMA) values (22, ARRAY [221, 222, 223, 224], 24)
insert into STRINGS (ID, STRINGS, SCHEMA) values (23, ARRAY [225], 25)

insert into SUBJECT (ID, TYPE_DISCRIMINATOR, SUBJECT_TYPE, NAME, FIRST_NAME, MIDDLE_NAME, LAST_NAME, BIRTH, FOUNDED, ADDRESS, DEFAULT_PHOTO, DEFAULT_GALLERY, GALLERIES, AUDIO, VIDEO, FILES, LINKS, DESCRIPTION, COMMENTS) values (22, 'Company', 'COMPANY', 'Furch Guitars', null, null, null, null, '1981', 101, null, null, null, null, null, null, null, 'World-known company that makes not only solid wood guitars.', null)
insert into SUBJECT (ID, TYPE_DISCRIMINATOR, SUBJECT_TYPE, NAME, FIRST_NAME, MIDDLE_NAME, LAST_NAME, BIRTH, FOUNDED, ADDRESS, DEFAULT_PHOTO, DEFAULT_GALLERY, GALLERIES, AUDIO, VIDEO, FILES, LINKS, DESCRIPTION, COMMENTS) values (23, 'Person', 'PERSON', null, 'Nemo', null, 'Nobody', '?. ?. ????', null, null, null, null, null, null, null, null, null, 'Nobody knows who it is', null)

insert into VIDEO (ID, FILE_NAME, NAME, TYPE, DESCRIPTION, COMMENTS, LENGTH, RESOLUTION, ACQUIRED) values (2, 'poesy_reading.avi', 'Vogon poesy reading record', 'VIDEO', 'Live event record from Carnegie Hall', 'Hear that and die', '42:42', '4242x2424', '4. 2. 4242')
insert into VIDEO (ID, FILE_NAME, NAME, TYPE, DESCRIPTION, COMMENTS, LENGTH, RESOLUTION, ACQUIRED) values (3, 'video.avi', 'Some video', 'VIDEO', 'Some video not interesting', null, '6:54:32', null, null)
