--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


ALTER TABLE public.authorities OWNER TO postgres;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    employee_name character varying(255),
    employee_phone character varying(100),
    employee_address character varying(255),
    employee_email character varying(255),
    employee_age integer,
    position_id integer
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: employee_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.employee_employee_id_seq OWNER TO postgres;

--
-- Name: employee_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employee_employee_id_seq OWNED BY public.employee.employee_id;


--
-- Name: position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."position" (
    position_id integer NOT NULL,
    position_name character varying(255),
    description character varying(255),
    salary_range_start integer,
    salary_range_end integer
);


ALTER TABLE public."position" OWNER TO postgres;

--
-- Name: position_position_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.position_position_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.position_position_id_seq OWNER TO postgres;

--
-- Name: position_position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.position_position_id_seq OWNED BY public."position".position_id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    username character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: employee employee_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN employee_id SET DEFAULT nextval('public.employee_employee_id_seq'::regclass);


--
-- Name: position position_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."position" ALTER COLUMN position_id SET DEFAULT nextval('public.position_position_id_seq'::regclass);


--
-- Data for Name: authorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.authorities (username, authority) FROM stdin;
nick	ADMIN
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (employee_id, employee_name, employee_phone, employee_address, employee_email, employee_age, position_id) FROM stdin;
4	Mg Mg	0912345678	FL Avenue	mgmg@email.com	32	2
6	Hu Tao	0944444444	Wangsheng Parlor	hutao@gmail.com	18	5
8	John Doe	555-1234	123 Main St	john.doe@email.com	28	1
10	Bob Johnson	555-9876	789 Pine St	bob.johnson@email.com	42	3
15	Diluc	0942342213	Dawn Winery	diluc@yahoo.com	30	2
7	Nick	09456373738	Yankin, Yangon, Myanmar.	nyimyozin04@gmail.com	21	5
16	Alex Johnson	123-456-7890	123 Main St, Cityville	alex@email.com	28	1
17	Emma Davis	555-1111	456 Oak St	emma.davis@email.com	24	2
19	Sophia Miller	555-3333	321 Elm St	sophia.miller@email.com	27	1
20	Liam Harris	555-4444	654 Birch St	liam.harris@email.com	29	2
21	Ava Taylor	555-5555	987 Maple St	ava.taylor@email.com	26	3
22	Noah Martinez	555-6666	135 Pineapple St	noah.martinez@email.com	31	1
23	Olivia Rodriguez	555-7777	246 Cherry St	olivia.rodriguez@email.com	28	2
24	Ethan Brown	555-8888	357 Apple St	ethan.brown@email.com	30	3
25	Isabella White	555-9999	468 Banana St	isabella.white@email.com	25	1
26	Rem	0945683782278	Lugunica	rem@mail.com	18	4
27	Jean	09290834	Knights of Favonius Headquarters	jean@mail.com	30	1
29	Tartaglia	39812739	MORA	moraman@mail.com	21	3
32	dasda	dadadas	A place	whodis@email.com	21	2
30	Who is Dis	2121-2121-21	basho	whosdis@email.com	23	3
33	Who Dis	2121-2121	A place	whodis@email.com	21	2
34	Who Dis	2121-2121	A place	whodis	21	2
35	Who Dis	2121-2121	A place	whodis@email.com	21	2
\.


--
-- Data for Name: position; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."position" (position_id, position_name, description, salary_range_start, salary_range_end) FROM stdin;
1	Software Developer	Responsible for developing and maintaining software applications.	60000	90000
3	Back-end Developer	Handles server-side logic and databases.	65000	95000
4	UI/UX Designer	Designs user interfaces and improves user experience.	50000	80000
5	Data Scientist	Analyzes and interprets complex data sets.	70000	100000
6	Network Administrator	Manages and maintains an organization's computer networks.	55000	85000
2	Front-end Developer	Focused on creating user interfaces and experiences.	55000	85000
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (username, password, enabled) FROM stdin;
nick	$2a$12$jYm9vXIP/Gyuc6HPJQUNo.mNM74zqAi9e4o2Yd/0BbmTAWe4tlChm	t
\.


--
-- Name: employee_employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_employee_id_seq', 35, true);


--
-- Name: position_position_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.position_position_id_seq', 6, true);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);


--
-- Name: position position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."position"
    ADD CONSTRAINT position_pkey PRIMARY KEY (position_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- Name: ix_auth_username; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX ix_auth_username ON public.authorities USING btree (username, authority);


--
-- Name: employee employee_position_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_position_id_fkey FOREIGN KEY (position_id) REFERENCES public."position"(position_id);


--
-- Name: authorities fk_authorities_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES public.users(username);


--
-- PostgreSQL database dump complete
--

