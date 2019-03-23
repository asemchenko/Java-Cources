-- made by Andrii Semchenko

use task_site;
-- task 1
select (select count(*) from news) + (select count(*) from reviews) as total_amount;
-- task 2
select distinct nc_name,
                count(n_id) over(partition by nc_id) as amount
from news
       right join news_categories nc on news.n_category = nc.nc_id;
-- task 3
select distinct rc_name,
                count(r_id) over(partition by rc_id) as amount
from reviews
       right join reviews_categories rc on reviews.r_category = rc.rc_id;
-- task 4
select distinct nc_name                            as category_name,
                max(n_dt) over(partition by nc_id) as last_date
from news
       right join news_categories nc on news.n_category = nc.nc_id
where n_dt is not null
union
select distinct rc_name                            as category_name,
                max(r_dt) over(partition by rc_id) as last_date
from reviews
       right join reviews_categories rc on reviews.r_category = rc.rc_id
where r_dt is not null;
-- task 5
select p_name, b.b_id, b_url
from pages
       left join m2m_banners_pages m2mbp on pages.p_id = m2mbp.p_id
       left join banners b on m2mbp.b_id = b.b_id
where p_parent is null;
-- task 6
select distinct p_name
from pages
       inner join m2m_banners_pages m2mbp on pages.p_id = m2mbp.p_id;
-- task 7
select p_name
from pages
       left join m2m_banners_pages m2mbp on pages.p_id = m2mbp.p_id
where b_id is null;
-- task 8
select distinct b.b_id, b_url
from m2m_banners_pages
       inner join banners b on m2m_banners_pages.b_id = b.b_id;
-- task 9
select b.b_id, b_url
from m2m_banners_pages
       right join banners b on m2m_banners_pages.b_id = b.b_id
where m2m_banners_pages.b_id is null;
-- task 10
select b_id, b_url, b_click / b_show as percent_click
from banners
having percent_click >= 0.8;
-- task 11
select distinct p_name
from pages
       inner join m2m_banners_pages m2mbp on pages.p_id = m2mbp.p_id
       inner join banners b on m2mbp.b_id = b.b_id
where b_text is not null;
-- task 12
select distinct p_name
from pages
       inner join m2m_banners_pages m2mbp on pages.p_id = m2mbp.p_id
       inner join banners b on m2mbp.b_id = b.b_id
where b_pic is not null;
-- task 13
select *
from (select r_header as header, r_dt as `date`
      from reviews
      union
      select n_header, n_dt
      from news) t
having YEAR(`date`) = 2011;
-- task 14
select nc_name as name
from news_categories
       left join news n on news_categories.nc_id = n.n_category
where n_id is null
union
select rc_name
from reviews_categories
       left join reviews r on reviews_categories.rc_id = r.r_category
where r_id is null;
-- task 15
select n_header, n_dt
from news
       inner join news_categories nc on news.n_category = nc.nc_id
where nc_name = 'Логистика'
having year(n_dt) = 2012;
-- task 16
select distinct year(n_dt) as `year`, count(*) over(partition by year(n_dt)) as amount
from news;
-- task 17
select b_id, b_url
from (select distinct b_id, b_url, count(b_url) over(partition by b_url) as amount from banners) t
where amount > 1;
-- task 18
select pages.p_name, b_id, p.p_name as parent_name
from pages
       inner join pages p on pages.p_parent = p.p_id
       left join m2m_banners_pages m2mbp on pages.p_id = m2mbp.p_id
where p.p_name = 'Юридическим лицам';
-- task 19
select b_id, b_url, b_click / b_show as rate
from banners
where b_pic is not null
order by rate desc;
-- task 20
select n_header as header, n_dt as `date`
from news
union
select r_header, r_dt
from reviews
order by date
limit 1;
-- task 21
select b_url, b_id
from (select b_url, b_id, count(b_url) over(partition by b_url) as c from banners) t
where c = 1;
-- task 22
select p_name, count(banners.b_id) as c
from banners
       right join m2m_banners_pages m2mbp on banners.b_id = m2mbp.b_id
       right join pages p on m2mbp.p_id = p.p_id
group by p_name
having c > 0
order by c DESC, p_name;
-- task 23
(select n_header as header, n_dt as `date` from news order by n_dt DESC limit 1)
union
(select r_header, r_dt from reviews order by r_dt DESC limit 1);
-- task 24
select b_url, b_text
from banners
having locate(lower(substring_index(b_url, 'http://', -1)), lower(b_text)) > 0;
-- task 25
select p_name
from banners
       left join m2m_banners_pages m2mbp on banners.b_id = m2mbp.b_id
       left join pages p on m2mbp.p_id = p.p_id
order by b_click / b_show DESC
limit 1;
-- task 26
select avg(b_click / b_show) as average
from banners
where b_show > 0;
-- task 27
select avg(b_click / b_show) as average
from banners
where b_pic is null;
-- task 28
select count(*) as `count`
from pages
       inner join m2m_banners_pages m2mbp on pages.p_id = m2mbp.p_id
       inner join banners b on m2mbp.b_id = b.b_id
where p_parent is null;
-- task 29
with t as (select banners.b_id, b_url, count(p.p_id) as pages_count
           from banners
                  inner join m2m_banners_pages m2mbp on banners.b_id = m2mbp.b_id
                  inner join pages p on m2mbp.p_id = p.p_id
           group by banners.b_id, b_url)
select *
from t
where pages_count in (select max(pages_count) from t);

-- task 30
with t as (select p_name, count(b_id) as banners_amount
           from pages
                  inner join m2m_banners_pages m2mbp on pages.p_id = m2mbp.p_id
           group by m2mbp.p_id, p_name)
select *
from t
where banners_amount in (select max(banners_amount) from t);
