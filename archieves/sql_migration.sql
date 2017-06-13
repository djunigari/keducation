SET @@auto_increment_increment=1;
INSERT INTO school (fax,funding__type,name,phone,postal_address_1,postal_address_2,postal_address_3,post_code,street,website,authority_school_id,category_school_id,regional_council_id,suburb_id,territorial_authority,type_school_id)
select sl.fax,sl.funding_type,sl.name,sl.phone,sl.postal_address_1,sl.postal_address_2,sl.postal_address_3,sl.post_code,sl.street,sl.website
            ,aus.authority_school_id
            ,cs.category_school_id
            ,rc.regional_council_id
            ,s.suburb_id
            ,ta.territorial_authority_id
            ,ts.type_school_id
from schoollists as sl
LEFT JOIN regional_council rc ON sl.regional_council = rc.name
LEFT JOIN type_school as ts ON sl.type = ts.name
LEFT JOIN category_school as cs ON sl.definition = cs.name
LEFT JOIN authority_school as aus ON sl.authority = aus.name
LEFT JOIN suburb as s ON sl.suburb = s.name
LEFT JOIN city as c ON sl.city = c.name
LEFT JOIN territorial_authority as ta ON sl.territorial_authority = ta.name order by sl.name;

SET @@auto_increment_increment=1;
INSERT INTO city (name)
Select distinct(city) from schoollists where city != '' order by city;

delete from school;
ALTER TABLE school AUTO_INCREMENT = 1;