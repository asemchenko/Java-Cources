-- made by Andrii Semchenko
USE task_site;

-- task 1

SELECT (SELECT count(*)
        FROM news) +
       (SELECT count(*)
        FROM reviews) AS total_amount;

-- task 2

SELECT DISTINCT nc_name,
                count(n_id) over(PARTITION BY nc_id) AS amount
FROM news
       RIGHT JOIN news_categories nc ON news.n_category = nc.nc_id;

-- task 3

SELECT DISTINCT rc_name,
                count(r_id) over(PARTITION BY rc_id) AS amount
FROM reviews
       RIGHT JOIN reviews_categories rc ON reviews.r_category = rc.rc_id;

-- task 4

SELECT DISTINCT nc_name                            AS category_name,
                max(n_dt) over(PARTITION BY nc_id) AS last_date
FROM news
       RIGHT JOIN news_categories nc ON news.n_category = nc.nc_id
WHERE n_dt IS NOT NULL
UNION
SELECT DISTINCT rc_name                            AS category_name,
                max(r_dt) over(PARTITION BY rc_id) AS last_date
FROM reviews
       RIGHT JOIN reviews_categories rc ON reviews.r_category = rc.rc_id
WHERE r_dt IS NOT NULL;

-- task 5

SELECT p_name,
       b.b_id,
       b_url
FROM pages
       LEFT JOIN m2m_banners_pages m2mbp ON pages.p_id = m2mbp.p_id
       LEFT JOIN banners b ON m2mbp.b_id = b.b_id
WHERE p_parent IS NULL;

-- task 6

SELECT DISTINCT p_name
FROM pages
       INNER JOIN m2m_banners_pages m2mbp ON pages.p_id = m2mbp.p_id;

-- task 7

SELECT p_name
FROM pages
       LEFT JOIN m2m_banners_pages m2mbp ON pages.p_id = m2mbp.p_id
WHERE b_id IS NULL;

-- task 8

SELECT DISTINCT b.b_id,
                b_url
FROM m2m_banners_pages
       INNER JOIN banners b ON m2m_banners_pages.b_id = b.b_id;

-- task 9

SELECT b.b_id,
       b_url
FROM m2m_banners_pages
       RIGHT JOIN banners b ON m2m_banners_pages.b_id = b.b_id
WHERE m2m_banners_pages.b_id IS NULL;

-- task 10

SELECT b_id,
       b_url,
       b_click / b_show AS percent_click
FROM banners
HAVING percent_click >= 0.8;

-- task 11

SELECT DISTINCT p_name
FROM pages
       INNER JOIN m2m_banners_pages m2mbp ON pages.p_id = m2mbp.p_id
       INNER JOIN banners b ON m2mbp.b_id = b.b_id
WHERE b_text IS NOT NULL;

-- task 12

SELECT DISTINCT p_name
FROM pages
       INNER JOIN m2m_banners_pages m2mbp ON pages.p_id = m2mbp.p_id
       INNER JOIN banners b ON m2mbp.b_id = b.b_id
WHERE b_pic IS NOT NULL;

-- task 13

SELECT *
FROM (SELECT r_header AS header,
             r_dt     AS `date`
      FROM reviews
      UNION
      SELECT n_header,
             n_dt
      FROM news) t
HAVING YEAR(`date`) = 2011;

-- task 14

SELECT nc_name AS name
FROM news_categories
       LEFT JOIN news n ON news_categories.nc_id = n.n_category
WHERE n_id IS NULL
UNION
SELECT rc_name
FROM reviews_categories
       LEFT JOIN reviews r ON reviews_categories.rc_id = r.r_category
WHERE r_id IS NULL;

-- task 15

SELECT n_header,
       n_dt
FROM news
       INNER JOIN news_categories nc ON news.n_category = nc.nc_id
WHERE nc_name = 'Логистика'
HAVING year(n_dt) = 2012;

-- task 16

SELECT DISTINCT year(n_dt)                             AS `year`,
                count(*) over(PARTITION BY year(n_dt)) AS amount
FROM news;

-- task 17

SELECT b_id,
       b_url
FROM (SELECT DISTINCT b_id,
                      b_url,
                      count(b_url) over(PARTITION BY b_url) AS amount
      FROM banners) t
WHERE amount > 1;

-- task 18

SELECT pages.p_name,
       b_id,
       p.p_name AS parent_name
FROM pages
       INNER JOIN pages p ON pages.p_parent = p.p_id
       LEFT JOIN m2m_banners_pages m2mbp ON pages.p_id = m2mbp.p_id
WHERE p.p_name = 'Юридическим лицам';

-- task 19

SELECT b_id,
       b_url,
       b_click / b_show AS rate
FROM banners
WHERE b_pic IS NOT NULL
ORDER BY rate DESC;

-- task 20

SELECT n_header AS header,
       n_dt     AS `date`
FROM news
UNION
SELECT r_header,
       r_dt
FROM reviews
ORDER BY date
LIMIT 1;

-- task 21

SELECT b_url,
       b_id
FROM (SELECT b_url,
             b_id,
             count(b_url) over(PARTITION BY b_url) AS c
      FROM banners) t
WHERE c = 1;

-- task 22

SELECT p_name,
       count(banners.b_id) AS c
FROM banners
       RIGHT JOIN m2m_banners_pages m2mbp ON banners.b_id = m2mbp.b_id
       RIGHT JOIN pages p ON m2mbp.p_id = p.p_id
GROUP BY p_name
HAVING c > 0
ORDER BY c DESC,
         p_name;

-- task 23

(SELECT n_header AS header,
        n_dt     AS `date`
 FROM news
 ORDER BY n_dt DESC
 LIMIT 1)
UNION
(SELECT r_header,
        r_dt
 FROM reviews
 ORDER BY r_dt DESC
 LIMIT 1);

-- task 24

SELECT b_url,
       b_text
FROM banners
HAVING locate(lower(substring_index(b_url, 'http://', -1)), lower(b_text)) > 0;

-- task 25

SELECT p_name
FROM banners
       LEFT JOIN m2m_banners_pages m2mbp ON banners.b_id = m2mbp.b_id
       LEFT JOIN pages p ON m2mbp.p_id = p.p_id
ORDER BY b_click / b_show DESC
LIMIT 1;

-- task 26

SELECT avg(b_click / b_show) AS average
FROM banners
WHERE b_show > 0;

-- task 27

SELECT avg(b_click / b_show) AS average
FROM banners
WHERE b_pic IS NULL;

-- task 28

SELECT count(*) AS `count`
FROM pages
       INNER JOIN m2m_banners_pages m2mbp ON pages.p_id = m2mbp.p_id
       INNER JOIN banners b ON m2mbp.b_id = b.b_id
WHERE p_parent IS NULL;

-- task 29
WITH t AS
       (SELECT banners.b_id,
               b_url,
               count(p.p_id) AS pages_count
        FROM banners
               INNER JOIN m2m_banners_pages m2mbp ON banners.b_id = m2mbp.b_id
               INNER JOIN pages p ON m2mbp.p_id = p.p_id
        GROUP BY banners.b_id,
                 b_url)
SELECT *
FROM t
WHERE pages_count IN
      (SELECT max(pages_count)
       FROM t);

-- task 30
WITH t AS
       (SELECT p_name,
               count(b_id) AS banners_amount
        FROM pages
               INNER JOIN m2m_banners_pages m2mbp ON pages.p_id = m2mbp.p_id
        GROUP BY m2mbp.p_id,
                 p_name)
SELECT *
FROM t
WHERE banners_amount IN
      (SELECT max(banners_amount)
       FROM t);
