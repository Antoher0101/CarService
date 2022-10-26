CREATE OR REPLACE FUNCTION reset_default_city() RETURNS trigger AS $reset_default_city$
    BEGIN
	UPDATE carservice_City
	SET default_city = 'f'
	WHERE default_city = 't';
	return NEW;
    END;
$reset_default_city$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS default_city_changed ON carservice_City;
CREATE TRIGGER default_city_changed
BEFORE UPDATE OF default_city ON carservice_City
FOR EACH ROW
WHEN(NEW.default_city = 't')
EXECUTE FUNCTION reset_default_city();