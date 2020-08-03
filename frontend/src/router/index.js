import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import("../views/Login.vue")
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: () => import('@/dashboard/Dashboard.vue'),
    },

      //Manager
    {
      path: '/manager',
      name: 'ManagerIndex',
      component: () => import('../stakeholderScreens/manager/ManagerIndex.vue'),
      children: [
        {
          path: 'addEvidence',
          name: 'AddBidder',
          component: () =>
              import(
                  '@/stakeholderScreens/manager/src/addEvidence/SubmitEvidence.vue'
                  ),
        },
        {
          path: 'bidderadded',
          name: 'BidderAdded',
          component: () =>
              import(
                  '@/stakeholderScreens/manager/src/addEvidence/EvidenceAdded.vue'
                  ),
        },
        {
          path: 'viewAll',
          name: 'ViewAll',
          component: () =>
              import(
                  '@/stakeholderScreens/manager/src/ViewAllEvidences.vue'
                  ),
        },
        {
          path: 'bidderDetails',
          name: 'BidderDetails',
          component: () =>
              import(
                  '@/stakeholderScreens/manager/src/pendingForReview/EvidenceDetails.vue'
                  ),
        },
        {
          path: 'pendingForReview',
          name: 'PendingForReview',
          component: () =>
              import(
                  '@/stakeholderScreens/manager/src/pendingForReview/PendingForReview.vue'
                  ),
        },
        {
          path: 'bidderRegistered',
          name: 'BidderRegisteredConfirmation',
          component: () =>
              import(
                  '@/stakeholderScreens/manager/src/pendingForReview/EvidenceRegistered.vue'
                  ),
        },
        {
          path: 'suspendedBidder',
          name: 'SuspendedBidder',
          component: () =>
              import(
                  '@/stakeholderScreens/manager/src/SuspendedBidders.vue'
                  ),
        },
      ],
    },
      //Auditor
    {
      path: '/auditor',
      name: 'AuditorIndex',
      component: () => import('../stakeholderScreens/auditor/AuditorIndex.vue'),
      children: [
        {
          path: 'auditEvidenceReport',
          name: 'AuditEvidenceReport',
          component: () => import('@/stakeholderScreens/auditor/src/AuditEvidenceReport.vue'),
        },
        {
          path: 'evidenceFraudReport',
          name: 'EvidenceFraudReport',
          component: () => import('@/stakeholderScreens/auditor/src/EvidenceFraudReport.vue'),
        },
        {
          path: 'evidenceInquiries',
          name: 'EvidenceInquiries',
          component: () => import('@/stakeholderScreens/auditor/src/EvidenceInquiries.vue'),
        },
        {
          path: 'auditorLogs',
          name: 'AuditorLogs',
          component: () => import('@/stakeholderScreens/auditor/src/AuditorLogs.vue'),
        },
      ],
    },
     // Deponent
    {
      path: '/deponent',
      name: 'DeponentIndex',
      component: () => import('@/stakeholderScreens/deponent/DeponentIndex.vue'),
      children: [
        // {
        //   path: 'verifyEvidence',
        //   name: 'VerifyEvidence',
        //   component: () =>
        //       import( '@/stakeholderScreens/deponent/src/VerifyEvidence.vue' ),
        // },
        {
          path: 'evidenceSubmissions',
          name: 'EvidenceSubmissions',
          component: () =>
              import( '@/stakeholderScreens/deponent/src/EvidenceSubmissions.vue' ),
        },
        {
          path: 'submitNewEvidence',
          name: 'SubmitNewEvidence',
          component: () =>
              import( '@/stakeholderScreens/deponent/src/SubmitNewEvidence.vue' ),
        },
        {
          path: 'evidenceSubmittedAlert',
          name: 'EvidenceSubmittedAlert',
          component: () =>
              import( '@/stakeholderScreens/deponent/src/EvidenceSubmittedAlert.vue' ),
        },
        // {
        //   path: 'evidenceFalsified',
        //   name: 'EvidenceFalsified',
        //   component: () =>
        //       import( '@/stakeholderScreens/deponent/src/EvidenceFalsified.vue' ),
        // },
        // {
        //   path: 'evidenceAdmissible',
        //   name: 'EvidenceAdmissible',
        //   component: () =>
        //       import( '@/stakeholderScreens/deponent/src/EvidenceAdmissible.vue' ),
        // },
      ],
    },

    // onBoarding
    {
      path: '/onboarding',
      name: 'OnBoardingIndex',
      component: () => import("../stakeholderScreens/onBoarding/OnBoardingIndex.vue"),
      children: [
        {
          path: 'addUser',
          name: 'AddUser',
          component: () =>
              import('@/stakeholderScreens/onBoarding/user/AddUser.vue'),
        },
        {
          path: 'viewAll',
          name: 'ViewAll',
          component: () =>
              import('@/stakeholderScreens/onBoarding/user/ViewAll.vue'),
        },
        {
          path: 'allUserRoles',
          name: 'AllUserRoles',
          component: () =>
              import(
                  '@/stakeholderScreens/onBoarding/user/AllUserRoles.vue'
                  ),
        },
      ],
    },

    // Forensic Experts

    {
      path: '/forensicExperts',
      name: 'ForensicExpertsIndex',
      component: () =>
          import('@/stakeholderScreens/forensicExperts/ForensicExpertsIndex.vue'),
      children: [
        {
          path: 'approvedEvidences',
          name: 'ApprovedEvidencesForensicExperts',
          component: () => import('@/stakeholderScreens/forensicExperts/src/ApprovedEvidencesForensicExperts.vue'),
        },
        {
          path: 'evidenceReportFindings',
          name: 'EvidenceReportFindings',
          component: () => import('@/stakeholderScreens/forensicExperts/src/EvidenceReportFindings.vue'),
        },
        {
          path: 'testifiedEvidences',
          name: 'TestifiedEvidences',
          component: () => import('@/stakeholderScreens/forensicExperts/src/TestifiedEvidences.vue'),
        },
        {
          path: 'rejectedEvidences',
          name: 'RejectedEvidences',
          component: () => import('@/stakeholderScreens/forensicExperts/src/RejectedEvidences.vue'),
        },
      ],
    },

    // Legal Team

    {
      path: '/legalTeam',
      name: 'LegalTeamIndex',
      component: () =>
          import( '@/stakeholderScreens/legalTeam/LegalTeamIndex.vue' ),
      children: [
        {
          path: 'approvedEvidences',
          name: 'ApprovedEvidencesLegalTeam',
          component: () =>
              import('@/stakeholderScreens/legalTeam/src/ApprovedEvidencesLegalTeam.vue'),
        },
        {
          path: 'assignCertificates',
          name: 'AssignCertificates',
          component: () =>
              import( '@/stakeholderScreens/legalTeam/src/assignCertificates/AssignCertificates.vue'),
        },
        {
          path: 'legalTeamVerifiedEvidences',
          name: 'LegalTeamVerifiedEvidences',
          component: () =>
              import( '@/stakeholderScreens/legalTeam/src/LegalTeamVerifiedEvidences.vue'),
        },

      ],
    },

]

const router = new VueRouter({
  routes
})

export default router
