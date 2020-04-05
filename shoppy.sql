-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 06 avr. 2020 à 00:42
-- Version du serveur :  10.1.39-MariaDB
-- Version de PHP :  7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `shoppy`
--

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `nomAnnonce` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `nbSignal` int(11) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `heure` time NOT NULL,
  `photo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `nbrrating` int(11) DEFAULT NULL,
  `nbruser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id`, `id_user`, `nomAnnonce`, `dateDebut`, `dateFin`, `adresse`, `description`, `nbSignal`, `type`, `heure`, `photo`, `rating`, `nbrrating`, `nbruser`) VALUES
(2, 11, 'Iphone 12+ bon occ', '2020-04-05', '2020-06-01', 'Ariana', 'azeaze', NULL, 'autres', '15:21:00', 'C:\\Users\\hamdi\\Desktop\\53584710_663314730750629_4762261670540083200_n.jpg', 5, NULL, NULL),
(3, 1, 'Ariana is dying', '2020-04-05', '2099-04-11', 'Ariana', 'azeaz', NULL, 'corona', '13:26:00', 'C:\\wamp64\\www\\shoppyBlog\\web\\uploads\\annonce\\a.jpg', 10, NULL, NULL),
(4, 11, 'Dying', '2020-04-05', '2021-04-25', '', 'aaz', NULL, 'electro', '13:07:00', NULL, 3, NULL, NULL),
(5, 11, 'talfza lel bii3 ', '2020-04-05', '2022-04-24', 'Tunisia', 'hello', NULL, 'maison', '14:11:00', 'C:\\Users\\hamdi\\Desktop\\54520647_663319550750147_8248660317475700736_n.jpg', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

CREATE TABLE `fos_user` (
  `id` int(11) NOT NULL,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `genre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rue` longtext COLLATE utf8_unicode_ci,
  `zip_code` int(11) DEFAULT NULL,
  `ville` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pays` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nbsignal` int(11) DEFAULT NULL,
  `datenaiss` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `genre`, `nom`, `prenom`, `rue`, `zip_code`, `ville`, `pays`, `phone`, `nbsignal`, `datenaiss`) VALUES
(1, 'admin', 'admin', 'hamdi.gtari@esprit.tn', 'hamdi.gtari@esprit.tn', 1, NULL, '$2y$10$FwkBTNC8mIwBdxiv1Wxn6eMqTEwgkxMWDl6mC7aPVMo.1VPRDBDWa', NULL, NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', 'Homme', 'firas', 'Jerbi', 'Ariana', 2073, 'Ariana', 'Tunisie', NULL, 0, '2019-04-03 00:00:00'),
(11, 'client', 'client', 'hamdi.gtari@yahoo.com', 'hamdi.gtari@yahoo.com', 1, NULL, '$2y$10$4d5Q8XSZ27x4uulfueDa7em.shbzmZks8ewcYtzuKGyUxoQ1B9ApK', NULL, NULL, NULL, 'a:1:{i:0;s:9:\"ROLE_USER\";}', 'Homme', 'firas', 'Jerbi', 'Ariana', 2073, 'Ariana', 'Tunisie', NULL, 0, '2019-04-03 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `profile`
--

CREATE TABLE `profile` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `tagline` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `about_me` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `profile`
--

INSERT INTO `profile` (`id`, `id_user`, `tagline`, `image`, `updated_at`, `about_me`) VALUES
(5, 1, '\"But man is not made for defeat. A man can be destroyed but not defeated.\"', '5acd033b1ca8f.jpg', '2020-04-01 19:32:27', '* Studied software-engineering at INSAT, past: Lycée Pilote Bourguiba Tunis, lives in Fondouk El Djedid, Nabul, Tunisia and is from ElKef.'),
(10, 10, 'Hey, it\'s a tagline', NULL, '2018-04-10 19:33:37', 'Hi, it\'s an aboutMe section, je suis une princesse, je vous aime putain les fifiiiis d\'amouuree <3 <3'),
(11, 11, 'hello', NULL, '2019-04-06 12:49:27', 'rien');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_B26681E6B3CA4B` (`id_user`);

--
-- Index pour la table `fos_user`
--
ALTER TABLE `fos_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  ADD UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  ADD UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`);

--
-- Index pour la table `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_8157AA0F6B3CA4B` (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `fos_user`
--
ALTER TABLE `fos_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `profile`
--
ALTER TABLE `profile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `FK_B26681E6B3CA4B` FOREIGN KEY (`id_user`) REFERENCES `fos_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
