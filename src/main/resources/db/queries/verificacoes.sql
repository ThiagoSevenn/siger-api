-- ============================================================
--  SIGER — Scripts de Verificação de Dados
--  Banco: PostgreSQL | Schema: bd_siger (sem prefixo de schema,
--  ajuste adicionando "bd_siger." se necessário)
-- ============================================================


-- ============================================================
-- 1. USUÁRIOS
-- ============================================================

-- Todos os usuários cadastrados
SELECT id, name, email, cpf, phone, status, type, created_at, last_login
FROM tb_user
ORDER BY created_at DESC;

-- Verificar um usuário específico por e-mail
SELECT id, name, email, cpf, phone, status, type, created_at, last_login
FROM tb_user
WHERE email = 'email@exemplo.com';

-- Verificar um usuário específico por CPF
SELECT id, name, email, cpf, status, type, created_at
FROM tb_user
WHERE cpf = '00000000000';

-- Usuários ativos
SELECT id, name, email, type, last_login
FROM tb_user
WHERE status = 'ATIVO'
ORDER BY name;

-- Usuários inativos
SELECT id, name, email, type, created_at
FROM tb_user
WHERE status = 'INATIVO'
ORDER BY name;

-- Contagem de usuários por status e tipo
SELECT status, type, COUNT(*) AS total
FROM tb_user
GROUP BY status, type
ORDER BY status, type;


-- ============================================================
-- 2. REUNIÕES
-- ============================================================

-- Todas as reuniões (mais recentes primeiro)
SELECT id, title, status, meeting_date, duration, location, organizer_id, created_at
FROM tb_meeting
ORDER BY created_at DESC;

-- Verificar uma reunião específica por título
SELECT id, title, description, status, meeting_date, duration, location, organizer_id
FROM tb_meeting
WHERE title ILIKE '%título da reunião%';

-- Reuniões com nome do organizador
SELECT m.id,
       m.title,
       m.status,
       m.meeting_date,
       m.duration,
       m.location,
       u.name  AS organizador,
       u.email AS email_organizador
FROM tb_meeting m
JOIN tb_user u ON u.id = m.organizer_id
ORDER BY m.meeting_date DESC;

-- Reuniões por status
SELECT m.id, m.title, m.meeting_date, u.name AS organizador
FROM tb_meeting m
JOIN tb_user u ON u.id = m.organizer_id
WHERE m.status = 'NAO_INICIADO'   -- NAO_INICIADO | EM_ANDAMENTO | CONCLUIDO
ORDER BY m.meeting_date;

-- Reuniões de um organizador específico (por e-mail)
SELECT m.id, m.title, m.status, m.meeting_date, m.location
FROM tb_meeting m
JOIN tb_user u ON u.id = m.organizer_id
WHERE u.email = 'email@exemplo.com'
ORDER BY m.meeting_date DESC;

-- Contagem de reuniões por status
SELECT status, COUNT(*) AS total
FROM tb_meeting
GROUP BY status;


-- ============================================================
-- 3. PARTICIPANTES
-- ============================================================

-- Todos os participantes (com nome e reunião)
SELECT p.id,
       u.name          AS participante,
       u.email,
       m.title         AS reuniao,
       p.role,
       p.participation
FROM tb_participant p
JOIN tb_user    u ON u.id = p.user_id
JOIN tb_meeting m ON m.id = p.meeting_id
ORDER BY m.title, u.name;

-- Participantes de uma reunião específica (por título)
SELECT p.id,
       u.name  AS participante,
       u.email,
       p.role,
       p.participation
FROM tb_participant p
JOIN tb_user    u ON u.id = p.user_id
JOIN tb_meeting m ON m.id = p.meeting_id
WHERE m.title ILIKE '%título da reunião%'
ORDER BY p.role, u.name;

-- Verificar se um usuário específico está em uma reunião
SELECT p.id, u.name, m.title, p.role, p.participation
FROM tb_participant p
JOIN tb_user    u ON u.id = p.user_id
JOIN tb_meeting m ON m.id = p.meeting_id
WHERE u.email = 'email@exemplo.com'
ORDER BY m.meeting_date DESC;

-- Contagem de participantes por reunião
SELECT m.title, COUNT(p.id) AS total_participantes
FROM tb_meeting m
LEFT JOIN tb_participant p ON p.meeting_id = m.id
GROUP BY m.id, m.title
ORDER BY total_participantes DESC;

-- Participação confirmada vs. pendente
SELECT m.title, p.participation, COUNT(*) AS total
FROM tb_participant p
JOIN tb_meeting m ON m.id = p.meeting_id
GROUP BY m.title, p.participation
ORDER BY m.title;


-- ============================================================
-- 4. ATAS DE REUNIÃO
-- ============================================================

-- Todas as atas com a reunião correspondente
SELECT mm.id,
       m.title   AS reuniao,
       m.status  AS status_reuniao,
       mm.objectives,
       mm.notes,
       mm.decision
FROM tb_meeting_minutes mm
JOIN tb_meeting m ON m.id = mm.meeting_id
ORDER BY m.meeting_date DESC;

-- Verificar se uma reunião já possui ata
SELECT
    m.id,
    m.title,
    m.status,
    CASE WHEN mm.id IS NOT NULL THEN 'SIM' ELSE 'NÃO' END AS possui_ata
FROM tb_meeting m
LEFT JOIN tb_meeting_minutes mm ON mm.meeting_id = m.id
ORDER BY m.meeting_date DESC;

-- Ata de uma reunião específica (por título)
SELECT mm.id, m.title, mm.objectives, mm.notes, mm.decision
FROM tb_meeting_minutes mm
JOIN tb_meeting m ON m.id = mm.meeting_id
WHERE m.title ILIKE '%título da reunião%';


-- ============================================================
-- 5. TÓPICOS / PAUTAS
-- ============================================================

-- Todos os tópicos com reunião e responsável
SELECT t.id,
       m.title    AS reuniao,
       t.title    AS topico,
       t.priority,
       t.concluded,
       t.order_index,
       t.timer,
       u.name     AS responsavel
FROM tb_topic t
JOIN tb_meeting_minutes mm ON mm.id = t.meeting_minutes_id
JOIN tb_meeting          m ON m.id  = mm.meeting_id
JOIN tb_participant       p ON p.id  = t.responsible_id
JOIN tb_user              u ON u.id  = p.user_id
ORDER BY m.title, t.order_index;

-- Tópicos pendentes (não concluídos) por prioridade
SELECT t.id,
       m.title    AS reuniao,
       t.title    AS topico,
       t.priority,
       u.name     AS responsavel
FROM tb_topic t
JOIN tb_meeting_minutes mm ON mm.id = t.meeting_minutes_id
JOIN tb_meeting          m ON m.id  = mm.meeting_id
JOIN tb_participant       p ON p.id  = t.responsible_id
JOIN tb_user              u ON u.id  = p.user_id
WHERE t.concluded = false
ORDER BY
    CASE t.priority WHEN 'ALTA' THEN 1 WHEN 'MEDIA' THEN 2 ELSE 3 END,
    m.title;

-- Tópicos de uma reunião específica
SELECT t.id, t.title, t.priority, t.concluded, t.order_index, t.timer, u.name AS responsavel
FROM tb_topic t
JOIN tb_meeting_minutes mm ON mm.id = t.meeting_minutes_id
JOIN tb_meeting          m ON m.id  = mm.meeting_id
JOIN tb_participant       p ON p.id  = t.responsible_id
JOIN tb_user              u ON u.id  = p.user_id
WHERE m.title ILIKE '%título da reunião%'
ORDER BY t.order_index;

-- Contagem de tópicos concluídos vs. pendentes por reunião
SELECT m.title,
       COUNT(*) FILTER (WHERE t.concluded = true)  AS concluidos,
       COUNT(*) FILTER (WHERE t.concluded = false) AS pendentes,
       COUNT(*)                                     AS total
FROM tb_topic t
JOIN tb_meeting_minutes mm ON mm.id = t.meeting_minutes_id
JOIN tb_meeting          m ON m.id  = mm.meeting_id
GROUP BY m.id, m.title
ORDER BY m.title;


-- ============================================================
-- 6. TOKENS DE RECUPERAÇÃO DE SENHA
-- ============================================================

-- Todos os tokens (mais recentes primeiro)
SELECT prt.id,
       u.email,
       u.name,
       prt.token,
       prt.expires_at,
       prt.used,
       CASE
           WHEN prt.used = true         THEN 'JÁ UTILIZADO'
           WHEN prt.expires_at < NOW()  THEN 'EXPIRADO'
           ELSE                              'VÁLIDO'
       END AS situacao
FROM tb_password_reset_token prt
JOIN tb_user u ON u.id = prt.user_id
ORDER BY prt.expires_at DESC;

-- Verificar o token mais recente de um usuário
SELECT prt.token, prt.expires_at, prt.used,
       CASE
           WHEN prt.used = true         THEN 'JÁ UTILIZADO'
           WHEN prt.expires_at < NOW()  THEN 'EXPIRADO'
           ELSE                              'VÁLIDO'
       END AS situacao
FROM tb_password_reset_token prt
JOIN tb_user u ON u.id = prt.user_id
WHERE u.email = 'email@exemplo.com'
ORDER BY prt.expires_at DESC
LIMIT 1;

-- Tokens válidos (não usados e não expirados)
SELECT u.email, u.name, prt.token, prt.expires_at
FROM tb_password_reset_token prt
JOIN tb_user u ON u.id = prt.user_id
WHERE prt.used = false
  AND prt.expires_at > NOW()
ORDER BY prt.expires_at;


-- ============================================================
-- 7. LOGS DE AUDITORIA
-- ============================================================

-- Todos os logs (mais recentes primeiro)
SELECT id, operation, user_name, date
FROM tb_log
ORDER BY date DESC;

-- Logs de um usuário específico
SELECT id, operation, date
FROM tb_log
WHERE user_name = 'nome.do.usuario'
ORDER BY date DESC;

-- Logs de hoje
SELECT id, operation, user_name, date
FROM tb_log
WHERE date::date = CURRENT_DATE
ORDER BY date DESC;

-- Logs de um intervalo de datas
SELECT id, operation, user_name, date
FROM tb_log
WHERE date BETWEEN '2025-01-01' AND '2025-12-31'
ORDER BY date DESC;

-- Contagem de operações por tipo
SELECT operation, COUNT(*) AS total
FROM tb_log
GROUP BY operation
ORDER BY total DESC;


-- ============================================================
-- 8. VISÃO GERAL (RESUMO DO SISTEMA)
-- ============================================================

SELECT
    (SELECT COUNT(*) FROM tb_user              WHERE status = 'ATIVO')   AS usuarios_ativos,
    (SELECT COUNT(*) FROM tb_user)                                         AS total_usuarios,
    (SELECT COUNT(*) FROM tb_meeting)                                      AS total_reunioes,
    (SELECT COUNT(*) FROM tb_meeting           WHERE status = 'CONCLUIDO') AS reunioes_concluidas,
    (SELECT COUNT(*) FROM tb_meeting           WHERE status = 'EM_ANDAMENTO') AS reunioes_em_andamento,
    (SELECT COUNT(*) FROM tb_participant)                                   AS total_participantes,
    (SELECT COUNT(*) FROM tb_meeting_minutes)                               AS total_atas,
    (SELECT COUNT(*) FROM tb_topic)                                         AS total_topicos,
    (SELECT COUNT(*) FROM tb_topic WHERE concluded = false)                 AS topicos_pendentes;
